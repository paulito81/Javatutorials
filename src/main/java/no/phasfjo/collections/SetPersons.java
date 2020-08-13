package no.phasfjo.collections;

import no.phasfjo.model.Person;

import java.util.*;

public class SetPersons {

    public SetPersons(){
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        Set<Person> madMen = new HashSet<>();
        madMen.add(donDraper);
        madMen.add(peggyOlsen);
        madMen.add(donDraper);

        // printout will be different each time only containing unique elements
        for (Person person : madMen){
            System.out.println(person);
        }

        // print out whether the hashset contains the value
        System.out.println(madMen.contains(donDraper) + ", " + donDraper.toString());
        System.out.println(madMen.contains(bertCooper));

    }
}
