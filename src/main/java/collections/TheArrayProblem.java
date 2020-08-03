package collections;

import model.Person;

import java.util.Arrays;

public class TheArrayProblem {

    public TheArrayProblem(){
        Person donDraper = new Person("Don Draper", 89);
        Person peggyOlsen = new Person("Peggy Olsen", 65);

        Person[] madMen = { donDraper, peggyOlsen};
        Person bertCooper = new Person("Bert Cooper", 100);
        //Call the method to add a new character
        madMen = add(bertCooper, madMen);
        System.out.println(Arrays.toString(madMen));


    }

    private Person[] add(final Person person, Person[] array ) {
        final int lenght = array.length;
        // new size
        array = Arrays.copyOf(array, lenght + 1);
        // add copy from index pos.
        array[lenght] = person;
        return array;
    }
}
