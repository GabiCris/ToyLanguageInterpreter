package domain.dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyList<T> implements MyIList<T> {
    private List<T> list = new ArrayList<>();

    @Override
    public void append(T elem) {
        list.add(elem);
    }

    @Override
    public void delete(T elem) {
        list.remove(elem);
    }

    @Override
    public String toString() {
        /*String message = "";
        for (T t : list) {
                message += t.toString() + "\n";
        }
        return message;*/
        return Arrays.toString(list.toArray());
    }

    public String toStringFile() {
        String message = "";
        for (T t : list) {
            message += t.toString() + System.lineSeparator();
        }
        return message;
    }
}
