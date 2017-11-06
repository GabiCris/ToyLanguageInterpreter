package view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Interpreter {
    public static void main(String[] args) {
/*        List<Dummy> l = new ArrayList<>();
        l.add(new Dummy(1, "unu"));
        l.add(new Dummy(2, "unu"));
        l.add(new Dummy(4, "dd"));

        List<Dummy> l1 = l.stream()
                .collect(Collectors.toList());
        List<Dummy> l2 = l.stream()
                .collect(Collectors.toList());

        l.get(0).s = "modified";
        l.forEach(System.out::println);
        l1.forEach(System.out::println);
        l2.forEach(System.out::println);
        */
        TextMenu menu = new TextMenu();
        menu.show();
    }
}
