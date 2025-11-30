package de.phl.programmingproject.enrollmentsystem;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

// Repräsentiert einen Studenten mit seinen Einschreibungen
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
        // Doppeltes Einschreiben verhindern
        if (enrollments.stream().noneMatch(e -> e.getCourse().equals(course))) {
            Enrollment enrollment = new Enrollment(this, course);
            enrollments.add(enrollment);
        }
    }

    public void drop(final Course course) {
        enrollments.removeIf(e -> e.getCourse().equals(course));
    }

    public boolean isEnrolledIn(final Course course) {
        return enrollments.stream().anyMatch(e -> e.getCourse().equals(course));
    }

    public List<Course> getCourses() {
        return enrollments.stream().map(Enrollment::getCourse).collect(Collectors.toList());
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }
}
