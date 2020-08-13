import no.phasfjo.collections.*;
import no.phasfjo.circular.CircularBuffer;
import no.phasfjo.circular.StringCircularBuffer;
import no.phasfjo.courses.CourseCatalog;
import no.phasfjo.courses.DevDictionary;
import no.phasfjo.erasures.InstanceOf;
import no.phasfjo.erasures.UncompilableException;
import no.phasfjo.guistuff.JavaGui;
import no.phasfjo.injectors.Injector;
import no.phasfjo.injectors.Logger;
import no.phasfjo.intersectiontype.IntersectionType;
import no.phasfjo.jsons.Jsondemo;
import no.phasfjo.lambda.LambdaCode;
import no.phasfjo.legacy.LegacyCode;
import no.phasfjo.persons.PersonReader;
import no.phasfjo.refeiables.NonReifiable;
import no.phasfjo.refeiables.Reifiable;
import no.phasfjo.sort.SortingPersons;
import no.phasfjo.sort.StringReverse;
import no.phasfjo.varargs.SafeVararg;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        runItAll();
    }

    private static void runItAll(){
        jsonDemo();
        devDictionary();
        courseCatalog();
        sort();
        unsafe();
        safe();
        collections();
        legacy();
        erasureOf();
        // uncompileException(); TODO Error crashes Exception in thread "main" java.lang.
        customArraylist();
        injector();
        refiable();
        lambda();
        personReader();
        intersectionType();
        varargs();
        stringReverse();
        guiStuff();

    }

    private static void jsonDemo(){
        Jsondemo jsondemo = new Jsondemo();
        jsondemo.initialize();
    }

    private static void devDictionary(){
        DevDictionary devDictionary = new DevDictionary();
        devDictionary.runApp();
    }

    private static void courseCatalog(){
        CourseCatalog courseCatalog = new CourseCatalog();
        courseCatalog.printCoursesByTopic("Java");
    }

    private static void sort(){
        new SortingPersons();
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
        new TheArrayProblem();
        new ListPersons();
        new SetPersons();
        new MapPersons();
    }

    private static void legacy(){
        new LegacyCode();
    }

    private static void erasureOf(){
        System.out.println(new InstanceOf<>() instanceof Object);
        // Unable to cast
        // System.out.println(new InstanceOf<>() instanceof Integer);
        System.out.println(new InstanceOf<>() instanceof InstanceOf);
    }

    //TODO Error crashes Exception in thread "main" java.lang.
    private static void uncompileException(){
       UncompilableException uncompilableException =  new UncompilableException();
        System.out.println(uncompilableException);
    }

    private static void customArraylist(){
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
        new Reifiable();
        new NonReifiable<String>();
    }

    private static void lambda(){
      new LambdaCode();
    }

    private static void personReader() {
        try {
            new PersonReader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void intersectionType(){
        try {
            new IntersectionType();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void varargs(){
         new SafeVararg();
    }

    private static void stringReverse(){
        String testkode = "apekatt";
        System.out.print(testkode +" blir til.. ");
        StringReverse reverse = new StringReverse(testkode);
        System.out.println(reverse.reverse(testkode));
    }

    private static void guiStuff(){
        new JavaGui(300, 40, "Title case converter");
    }

}
