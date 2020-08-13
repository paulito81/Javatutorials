package no.phasfjo.collections;

import no.phasfjo.model.Person;

import java.util.HashMap;
import java.util.Map;

public class MapPersons {

    public MapPersons(){
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);
        Person bertCooper = new Person("Bert Cooper", 100);

        // A map of Strings and Persons interconnected
        Map<String, Person> madMen = new HashMap<>();

        madMen.put(donDraper.getName(), donDraper);
        madMen.put(peggyOlsen.getName(), peggyOlsen);
        madMen.put(bertCooper.getName(), bertCooper);

      //  System.out.println(madMen.get("Don Draper"));
      //   System.out.println(madMen);

        for(Map.Entry<String,Person> entry: madMen.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
