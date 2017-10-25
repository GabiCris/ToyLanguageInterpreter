package domain.dataStructures;

import domain.MyStackException;

import java.util.Stack;

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
        String message = "";
        for (T t : stack) {
            message = message + t.toString();
        }
        return message;
    }
}
