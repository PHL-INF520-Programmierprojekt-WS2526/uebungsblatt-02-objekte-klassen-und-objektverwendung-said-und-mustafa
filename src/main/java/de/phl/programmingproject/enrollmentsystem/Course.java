package de.phl.programmingproject.enrollmentsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private final String name;
    private final List<Enrollment> enrollments = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getInfo() {
        return "Course: " + name;
    }

    public String getName() {
        return name;
    }

    // Enrollment eklenince öğrenci de eklenmiş olur
    protected void addEnrollment(Enrollment enrollment) {
        if (!enrollments.contains(enrollment)) {
            enrollments.add(enrollment);
        }
    }

    protected void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    public Enrollment enroll(final Student student) {
        return student.enroll(this);
    }

    public void drop(final Student student) {
        student.drop(this);
    }

    public boolean isStudentEnrolled(final Student student) {
        return enrollments.stream().anyMatch(e -> e.getStudent().equals(student));
    }

    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (Enrollment e : enrollments) {
            students.add(e.getStudent());
        }
        return students;
    }

    public List<Enrollment> getEnrollments() {
        return new ArrayList<>(enrollments);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}