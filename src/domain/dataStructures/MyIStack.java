package domain.dataStructures;

public interface MyIStack<T> {
    T pop();
    void push(T elem);
    boolean isEmpty();
    String toStringFile();
}
