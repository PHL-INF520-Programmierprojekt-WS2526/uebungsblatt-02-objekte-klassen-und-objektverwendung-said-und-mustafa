package de.phl.programmingproject.enrollmentsystem;

import java.util.Objects;

public class Enrollment {
    private final Student student;
    private final Course course;
    private double grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = 0.0;
    }

    public String getInfo() {
        return "Student: " + student.getName() + ", Course: " + course.getName() + ", Grade: " + grade;
    }

    public void setGrade(final double grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enrollment)) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(student, that.student) &&
               Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }
}