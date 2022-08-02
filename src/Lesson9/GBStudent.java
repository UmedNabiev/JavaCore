package Lesson9;

import java.util.ArrayList;
import java.util.List;

public class GBStudent implements Student {
    private String name;
    private List<Course> courses = new ArrayList<>();

    public String getName(){ return name; }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        courses.add(course);
    }

    @Override
    public List<Course> getAllCourses(){
        return courses;
    }
}
