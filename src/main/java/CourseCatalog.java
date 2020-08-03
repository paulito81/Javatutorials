
import model.Course;

import java.util.*;

public class CourseCatalog {

  // @Inject
    Map<String, List<Course>> catalog;

    public CourseCatalog() {
        catalog = new HashMap<>();
        initializeJavaCourses();
    }

    private void initializeJavaCourses() {
        Course spring = new Course("Spring");
        Course maps = new Course("Maps");
        Course lambdas = new Course("Lambdas");
        List<Course> javaCourses = new ArrayList<>(Arrays.asList(spring, maps, lambdas));
        catalog.put("Java", javaCourses);

    }

    public void printCoursesByTopic(String topic) {
        if(!topic.equals("") || topic == null) {
            System.out.println("We found the following classes within "  + topic + ":\n");
            for (Course entry : catalog.get(topic)) {
                System.out.println(topic +"-"+entry.getCoursename());
            }
        }
    }
}
