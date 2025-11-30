package de.phl.programmingproject.enrollmentsystem;

import java.util.ArrayList;
import java.util.List;

// Represents a course with enrolled students
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

    // Enrolls a student in this course
    public void enroll(final Student student) {
        if (!students.contains(student)) {
            students.add(student);
            // Student also manages its own enrollments (creates Enrollment obj)
            student.addEnrollment(this);
        }
    }

    // Drops a student from this course
    public void drop(final Student student) {
        if (students.contains(student)) {
            students.remove(student);
            student.removeEnrollment(this);
        }
    }

    public boolean isStudentEnrolled(final Student student) {
        return students.contains(student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }
}