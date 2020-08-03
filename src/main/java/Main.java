import collections.ListPersons;
import collections.MapPersons;
import circular.CircularBuffer;
import circular.StringCircularBuffer;
import collections.SetPersons;
import collections.TheArrayProblem;
import sort.SortingPersons;

public class Main {
    public static void main(String[] args) {
         sort();
    }
    private static void runItAll(){
        run();
        unsafe();
        safe();
        collections();
    }

    private static void run(){
        DevDictionary devDictionary = new DevDictionary();
        devDictionary.runApp();

        CourseCatalog courseCatalog = new CourseCatalog();
        courseCatalog.printCoursesByTopic("Java");

        Jsondemo jsondemo = new Jsondemo();
        jsondemo.initialize();

    }
    private static void sort(){
        SortingPersons sortingPersons = new SortingPersons();
    }

    private static void collections(){
        TheArrayProblem theArrayProblem = new TheArrayProblem();
        ListPersons listPersons = new ListPersons();
        SetPersons setPersons = new SetPersons();
        MapPersons mapPersons = new MapPersons();
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

}
