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

    // Only called from Student.enroll
    protected void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Only called from Student.drop
    protected void removeStudent(Student student) {
        students.remove(student);
    }

    // Course enroll delegates to Student.enroll
    public Enrollment enroll(final Student student) {
        return student.enroll(this);
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