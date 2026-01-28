package de.phl.programmingproject.enrollmentsystem;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

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

    public String getId() {
        return id;
    }

    // Student enrolls in a course
    public Enrollment enroll(final Course course) {
        if (!isEnrolledIn(course)) {
            Enrollment enrollment = new Enrollment(this, course);
            enrollments.add(enrollment);
            course.addEnrollment(enrollment);
            return enrollment;
        }
        for (Enrollment e : enrollments) {
            if (e.getCourse().equals(course)) {
                return e;
            }
        }
        return null;
    }

    // Student drops a course
    public void drop(final Course course) {
        Enrollment toRemove = null;
        for (Enrollment e : enrollments) {
            if (e.getCourse().equals(course)) {
                toRemove = e;
                break;
            }
        }
        if (toRemove != null) {
            enrollments.remove(toRemove);
            course.removeEnrollment(toRemove);
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
        return new HashSet<>(enrollments);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}