package no.phasfjo.legacy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyCode {
    // Java 5 example client code that is dependent on list, client-code
    //RAW type compatible with no.phasfjo.legacy library
    public LegacyCode(){
        legacyCode1();
        legacyCode2();
    }

    private void legacyCode1(){
        List list = new ArrayList();
        list.add("abc");
        list.add(1);
        list.add(new Object()) ;

        // This gives NOT a compile error in changing it to List<String>
        // But gives a runtime error java.lang.classCastException
        List<Integer> integers = new ArrayList<>();
        list = integers;
        List<String> strings = list;
        for (String s : strings){
            System.out.println(s);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            final Object element = iterator.next();
            System.out.println(element);
        }
    }
    // This is a different type than the above
    private void legacyCode2(){
        List<Object> list = new ArrayList<>();
        list.add("abc");
        list.add(1);
        list.add(new Object());

        // This gives a compile error -> List<String> strings = list;

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            final Object object = iterator.next();
            System.out.println(object);
        }
    }
    private void legacyCode3(){
        List list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);

        legacyMethod(integers);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            final Object element = iterator.next();
            System.out.println(element);
        }
    }
    private void legacyMethod(List list){
    }
}
