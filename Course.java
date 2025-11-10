package de.phl.programmingproject.enrollmentsystem;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - Students:");
        if (students.isEmpty()) sb.append(" none");
        else {
            for (Student s : students) {
                sb.append(" ").append(s.getName());
            }
        }
        return sb.toString();
    }
}
