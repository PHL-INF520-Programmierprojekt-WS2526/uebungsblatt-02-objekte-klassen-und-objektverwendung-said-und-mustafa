package de.phl.programmingproject.enrollmentsystem;

import java.util.ArrayList;
import java.util.List;

// Repräsentiert einen Kurs mit eingeschriebenen Studenten
public class Course {
    private final String name;
    private final List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getInfo() {
        return "Kurs: " + name;
    }

    public String getName() {
        return name;
    }

    public void enroll(final Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.enroll(this);
        }
    }

    public void drop(final Student student) {
        if (students.contains(student)) {
            students.remove(student);
            student.drop(this);
        }
    }

    public boolean isStudentEnrolled(final Student student) {
        return students.contains(student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}
