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

    // Called only by Student.enroll
    protected void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Called only by Student.drop
    protected void removeStudent(Student student) {
        students.remove(student);
    }

    // Course enroll just delegates to Student.enroll
    public void enroll(final Student student) {
        student.enroll(this);
    }

    public void drop(final Student student) {
        student.drop(this);
    }

    public boolean isStudentEnrolled(final Student student) {
        return students.contains(student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}