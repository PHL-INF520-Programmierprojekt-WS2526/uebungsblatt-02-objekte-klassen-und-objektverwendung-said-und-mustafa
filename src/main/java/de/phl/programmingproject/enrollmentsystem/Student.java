package de.phl.programmingproject.enrollmentsystem;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

// Represents a student with a set of enrollments
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

    // Enroll in a course using Course.enroll(this) to keep lists in sync
    public void enroll(final Course course) {
        course.enroll(this);
    }

    // Drop a course using Course.drop(this)
    public void drop(final Course course) {
        course.drop(this);
    }

    // Adds an Enrollment (called by Course.enroll)
    protected void addEnrollment(Course course) {
        if (!isEnrolledIn(course)) {
            enrollments.add(new Enrollment(this, course));
        }
    }

    // Removes an Enrollment (called by Course.drop)
    protected void removeEnrollment(Course course) {
        enrollments.removeIf(e -> e.getCourse().equals(course));
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