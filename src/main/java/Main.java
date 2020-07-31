public class Main {
    public static void main(String[] args) {
      run();
    }
    private static void run(){
        DevDictionary devDictionary = new DevDictionary();
        devDictionary.runApp();

        CourseCatalog courseCatalog = new CourseCatalog();
        courseCatalog.printCoursesByTopic("Java");

        Jsondemo jsondemo = new Jsondemo();
        jsondemo.initialize();
    }
}
