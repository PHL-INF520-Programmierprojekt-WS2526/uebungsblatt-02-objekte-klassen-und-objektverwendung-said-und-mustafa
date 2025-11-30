package de.phl.programmingproject.enrollmentsystem;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final String name;
    private final List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getInfo() {
        return "Course: " + name;
    }

    public String getName() {
        return name;
    }

    public void enroll(final Student student) {
        // Sadece yeni ise ekle
        if (!students.contains(student)) {
            students.add(student);
            // Student nesnesinde enrollment ekle
            if (!student.isEnrolledIn(this)) {
                student.enroll(this);
            }
        }
    }

    public void drop(final Student student) {
        if (students.contains(student)) {
            students.remove(student);
            if (student.isEnrolledIn(this)) {
                student.drop(this);
            }
        }
    }

    public boolean isStudentEnrolled(final Student student) {
        return students.contains(student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}