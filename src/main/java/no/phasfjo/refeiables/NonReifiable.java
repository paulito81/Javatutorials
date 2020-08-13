package no.phasfjo.refeiables;

import java.util.ArrayList;
import java.util.List;

public class NonReifiable<T> {

    public NonReifiable(){

        // Its not possible to get enough info: System.out.println(T.class);
        List<String> strings = new ArrayList<>();
        List<Integer> integers= new ArrayList<>();
        System.out.println(strings.getClass());
        System.out.println(integers.getClass());
        System.out.println(integers.getClass() == strings.getClass());

        List<? extends Number> numbers = new ArrayList<>();
        System.out.println(numbers.getClass());
        System.out.println(integers.getClass() == numbers.getClass());
    }
}
