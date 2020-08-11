import collections.*;
import circular.CircularBuffer;
import circular.StringCircularBuffer;
import erasures.InstanceOf;
import erasures.UncompilableException;
import injectors.Injector;
import injectors.Logger;
import intersectiontype.IntersectionType;
import lambda.LambdaCode;
import legacy.LegacyCode;
import persons.PersonReader;
import refeiables.NonReifiable;
import refeiables.Reifiable;
import sort.SortingPersons;
import varargs.SafeVararg;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      varargs();
    }

    private static void runItAll(){
        jsondemo();
        devdictionary();
        coursecatalog();
        sort();
        unsafe();
        safe();
        collections();
        legacy();
        erasureOf();
        uncompileexception();
        customarraylist();
        injector();
        refiable();
        lambda();
        personreader();
        intersectiontype();
    }

    private static void jsondemo(){
        Jsondemo jsondemo = new Jsondemo();
        jsondemo.initialize();
    }

    private static void devdictionary(){
        DevDictionary devDictionary = new DevDictionary();
        devDictionary.runApp();
    }
    private static void coursecatalog(){
        CourseCatalog courseCatalog = new CourseCatalog();
        courseCatalog.printCoursesByTopic("Java");
    }

    private static void sort(){
        SortingPersons sortingPersons = new SortingPersons();
    }
    private static void unsafe(){
        CircularBuffer<String> circularBuffer = new CircularBuffer<>(10);
        circularBuffer.offer("a");
        circularBuffer.offer("bc");
        circularBuffer.offer("d");

        String value = concatenate(circularBuffer);
        System.out.println(value);
    }
    private static void safe(){
        StringCircularBuffer stringCircularBuffer = new StringCircularBuffer(10);
        stringCircularBuffer.offer("a");
        stringCircularBuffer.offer("bc");

        String value  = concatenate(stringCircularBuffer);
        System.out.println(value);
    }
    private static String concatenate(StringCircularBuffer stringCircularBuffer){
        StringBuilder result = new StringBuilder();
        String value;
        while ((value = stringCircularBuffer.poll()) !=null){
            result.append(value);
        }
        return result.toString();
    }

    private static String concatenate(CircularBuffer<String> circularBuffer) {
        StringBuilder result = new StringBuilder();
        String value;
        while ((value = circularBuffer.poll()) !=null){
            result.append(value);
        }
        return result.toString();
    }

    private static void collections(){
        TheArrayProblem theArrayProblem = new TheArrayProblem();
        ListPersons listPersons = new ListPersons();
        SetPersons setPersons = new SetPersons();
        MapPersons mapPersons = new MapPersons();
    }

    private static void legacy(){
        LegacyCode legacyCode = new LegacyCode();
    }

    private static void erasureOf(){
        System.out.println(new InstanceOf<>() instanceof Object);
        // Unable to cast
        // System.out.println(new InstanceOf<>() instanceof Integer);
        System.out.println(new InstanceOf<>() instanceof InstanceOf);
    }

    private static void uncompileexception(){
        UncompilableException uncompilableException = new UncompilableException();
    }

    private static void customarraylist(){
        List<Integer> arrayList = new CustomArrayList<>();

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));
        System.out.println(arrayList.get(2));
    }

    private static void injector(){
        Injector injector = new Injector().with("Hello World");
        //Logger logger = (Logger) injector.newInstance("Logger");
        Logger logger = injector.newInstance(Logger.class);
        logger.log();
    }
    private static void refiable(){
        Reifiable reifiable = new Reifiable();
        NonReifiable<String> reifiable1 = new NonReifiable<String>();
    }
    private static void lambda(){
       LambdaCode lambdaCode = new LambdaCode();

    }
    private static void personreader() {
        try {
            PersonReader personReader = new PersonReader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void intersectiontype(){
        try {
            IntersectionType intersectiontype = new IntersectionType();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void varargs(){
        SafeVararg safeVararg = new SafeVararg();
    }
}
