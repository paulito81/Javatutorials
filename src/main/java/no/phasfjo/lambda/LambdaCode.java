package no.phasfjo.lambda;

import no.phasfjo.model.Person;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class LambdaCode {

    private Predicate<Person> isOld = person -> person.getAge() > 80;

    public LambdaCode(){
        createSomePeople();
        createAListOfPersonsCheckWhoIsOld();
    }

    private Predicate<Person> isOld(){
        return isOld = person -> person.getAge() > 80;
    }

    private void createSomePeople(){
        System.out.println("\n-----------------PEOPLE TEST------------");
        final Person donDraper = new Person("Don Draper", 89);
        final Person peggyOlsen = new Person("Peggy Olsen", 75);
        final Person bertCooper = new Person("Bert Cooper", 100);

        //Check if person.txt.txt is more than 80 years
        System.out.println("Is Don Draper  old? = " + isOld.test(donDraper));
        System.out.println("Is Peggy Olsen old? = " + isOld.test(peggyOlsen) + "\n");
    }

    private void createAListOfPersonsCheckWhoIsOld(){
        System.out.println("-----------------LIST TEST------------");
        final Person donDraper = new Person("Don Draper", 89);
        final Person peggyOlsen = new Person("Peggy Olsen", 75);
        final Person bertCooper = new Person("Bert Cooper", 100);
        List<Person> people = new ArrayList<>();
        people.add(donDraper);
        people.add(peggyOlsen);
        people.add(bertCooper);
        Map<Boolean, List<Person>> oldAndYoungPeople =  people.stream().collect(Collectors.partitioningBy( isOld() ));
        System.out.println(oldAndYoungPeople);
        countHowManyPersonsOver80(people);
    }

    private void countHowManyPersonsOver80(@NotNull List<Person> peopleArray){
        System.out.println("\n-----------------COUNT PEOPLES-----------");
        Map<Boolean, Long> oldAndYoungPeople = peopleArray.stream().collect(partitioningBy(isOld, counting()) );
        System.out.println(oldAndYoungPeople);
    }
}

