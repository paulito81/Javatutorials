package no.phasfjo.sort;

import no.phasfjo.model.Person;

import java.util.*;

import static java.util.Collections.min;

public class SortingPersons {

    public SortingPersons(){
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlsen);
        madMen.add(bertCooper);

        //initial order
        System.out.println(madMen);

        // First parameter list of things to no.phasfjo.sort,
        // second is a comparator - defines the order in which things get sorted
        Collections.sort(madMen, new AgeComparator());
        System.out.println(madMen);

        //Reverse order of comparator
        Collections.sort(madMen, new ReverseComparator<>(new AgeComparator()));
        System.out.println(madMen);

        final Person youngestCastMember = min(madMen, new AgeComparator());
        System.out.println(youngestCastMember);

        listOfStuff();
    }
    private void listOfStuff(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Prints the lowest numbers of our integers
        System.out.println(min(numbers, Integer::compare));
    }

    public <T> T min(List<T> values, Comparator<T> comparator) {
        if(values.isEmpty()){
            throw new IllegalArgumentException("List i empty, cannot find minimum ");
        }
        T lowestElement = values.get(0);
        for( int i = 1; i < values.size(); i++)
        {
            final T element = values.get(i);
            if(comparator.compare(element, lowestElement) < 0){
                lowestElement = element;
            }
        }
        return lowestElement;
    }

}
