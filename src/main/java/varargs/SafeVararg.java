package varargs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SafeVararg {

    public SafeVararg(){
        printoutValues();
        combine(Arrays.asList(1,2,3));
       // testPairArray();
    }

    @SafeVarargs
    private <T> T[] arrayOf(T ... values) {
        return values;
    }

    private <T> T[] pair(T t){
        return arrayOf(t, t);
    }

    private void printoutValues(){
        Integer[] integers = arrayOf(1, 2);
        System.out.println("Values: " +  Arrays.toString(integers));
        System.out.println("Type: " + integers.getClass());
    }


    private void testPairArray(){
        Object[] strings = pair("a");
        System.out.println(Arrays.toString(strings));
        System.out.println(strings.getClass());

        Integer[] pair = pair(1);
        System.out.println(Arrays.toString(pair));
        System.out.println(pair.getClass());
    }

    @SafeVarargs
    // Create a new list and loop over the array parameters
    private <T>List<T> combine(List<? extends T> ... lists) {
        List<T> combined = new ArrayList<>();
        for(List<? extends T> list : lists){
            combined.addAll(list);
        }
        return combined;
    }
}
