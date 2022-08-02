package Lesson9;

public class GBCourse implements Course {
    private String name;

    GBCourse(String name){
        this.name = name;
    }

    public String getName(){ return name; }

    public void setName(String name) {
        this.name = name;
    }
}
