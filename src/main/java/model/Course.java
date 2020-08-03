package model;

public class Course {
    private String coursename;
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Course(String coursename) {
        this.coursename = coursename;
    }
    public Course(){

    }
}
