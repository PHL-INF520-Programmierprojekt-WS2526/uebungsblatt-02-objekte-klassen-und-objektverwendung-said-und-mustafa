package de.phl.programmingproject.enrollmentsystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String id;
    private List<Course> courses;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public Enrollment enroll(Course course) {
        Enrollment enrollment = new Enrollment(this, course);
        courses.add(course);
        course.addStudent(this);
        return enrollment;
    }

    public void drop(Course course) {
        courses.remove(course);
        course.removeStudent(this);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(id).append(")\nCourses:");
        if (courses.isEmpty()) sb.append(" none");
        else {
            for (Course c : courses) {
                sb.append(" ").append(c.getName());
            }
        }
        return sb.toString();
    }
}
