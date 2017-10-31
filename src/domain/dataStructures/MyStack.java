package domain.dataStructures;

import domain.MyStackException;

import java.util.*;
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

    public String toStringFile() {
        /*return stack.stream()
                .map(T::toString)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.joining(System.lineSeparator()));*/
        List<T> list = new ArrayList<>();
        for (T el : stack) {
            list.add(el);
        }
        Collections.reverse(list);
        String msg = "";
        for (T e : list) {
            msg += e + System.lineSeparator();
        }
        return msg;
    }
}
