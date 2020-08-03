package collections;

import model.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPersons {

    public ListPersons(){
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);

        // A List is a collection with a order
        List<Person> madMen = new ArrayList<>();
        madMen.add(donDraper);
        madMen.add(peggyOlsen);

        System.out.println(madMen);
        madMen.add(new Person("Bert Cooper", 100));
        System.out.println("Length of Madmen array, " +madMen.size());
        final Person person = madMen.get(2);
        System.out.println("Madmen with id:2 => " + person);

        System.out.println("\n1.For-loop");
        for (Person person1 : madMen) {
            System.out.println(person1);
        }
        final Iterator<Person> iterator = madMen.iterator();
        System.out.println("\n2.While-loop");
        while( iterator.hasNext()) {
           final Person person2 = iterator.next();
           System.out.println(person2);
       }
    }
}
