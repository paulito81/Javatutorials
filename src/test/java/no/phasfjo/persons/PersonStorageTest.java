package no.phasfjo.persons;

import no.phasfjo.model.Person;
import no.phasfjo.model.person.Employee;
import no.phasfjo.model.person.Partner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class PersonStorageTest
{
    private Partner donDraper = new Partner("Don Draper", 89);
    private Partner bertCooper = new Partner("Bert Cooper", 100);
    private Employee peggyOlsen= new Employee("Peggy Olsen", 69);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Before
    public void setUp() throws Exception
    {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    }

    @After
    public void tearDown()
    {
        if (file.exists())
        {
            file.delete();
        }
    }

    @Test
    public void savesAndLoadsPerson() throws Exception {
        Person person = new Person("Bob", 20);
        saver.save(person);

        assertEquals(person, loader.load());
    }

    @Test
    public void savesAndLoadsPartner() throws Exception {
        Partner peggy_olsen = new Partner("Peggy Olsen", 69);
        saver.save(peggy_olsen);

        assertEquals(peggy_olsen, loader.load());
    }

    @Test
    public void savesAndLoadsEmployee() throws Exception {
        Employee donDraper = new Employee("Don Draper", 89);
        saver.save(donDraper);

        assertEquals(donDraper, loader.load());
    }

    @Test
    public void savesAndLoadsArraysOfPartner() throws Exception{
        Partner[] persons = new Partner[2];
        persons[0] = donDraper;
        persons[1] = bertCooper;

        saver.saveAll(persons);

        assertEquals(2, persons.length);
        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    }

    @Test
    public void savesAndLoadsListOfPersons() throws Exception{
        List<Person> persons = new ArrayList<>();
        persons.add( donDraper);
        persons.add(bertCooper);

        saver.saveAll(persons);
        assertEquals(donDraper, loader.load());
        assertEquals(bertCooper, loader.load());
    }

    @Test
    public void loadsListOfPeople() throws Exception {
        saver.save(donDraper);
        saver.save(peggyOlsen);

        List<Person> people = new ArrayList<>();
        loader.loadAll(people);

        assertEquals(donDraper, people.get(0));
        assertNotSame(donDraper, people.get(1));
        assertNotSame(peggyOlsen, people.get(0));
        assertEquals(peggyOlsen, people.get(1));
    }
}
