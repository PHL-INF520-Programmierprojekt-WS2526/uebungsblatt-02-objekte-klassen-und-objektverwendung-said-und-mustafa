package de.phl.programmingproject.enrollmentsystem;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Student {
    private final String name;
    private final String id;
    private final Set<Enrollment> enrollments = new HashSet<>();

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getInfo() {
        return "Name: " + name + ", ID: " + id;
    }

    public String getName() {
        return name;
    }

    public void enroll(final Course course) {
        // Eğer zaten kayıtlıysa tekrar ekleme!
        if (!isEnrolledIn(course)) {
            Enrollment enrollment = new Enrollment(this, course);
            enrollments.add(enrollment);
            if (!course.isStudentEnrolled(this)) {
                course.enroll(this);
            }
        }
    }

    public void drop(final Course course) {
        enrollments.removeIf(e -> e.getCourse().equals(course));
        if (course.isStudentEnrolled(this)) {
            course.drop(this);
        }
    }

    public boolean isEnrolledIn(final Course course) {
        return enrollments.stream().anyMatch(e -> e.getCourse().equals(course));
    }

    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        for (Enrollment e : enrollments) {
            courses.add(e.getCourse());
        }
        return courses;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }
}