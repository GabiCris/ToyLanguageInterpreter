package domain.dataStructures;

import domain.MyStackException;

import java.util.Stack;
import java.util.stream.Collectors;

public class MyStack<T> implements MyIStack<T> {
    private Stack<T> stack = new Stack<>();

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public void push(T elem) {
        stack.push(elem);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.stream()
                .map(T::toString)
                .collect(Collectors.joining(" "));
    }
}
