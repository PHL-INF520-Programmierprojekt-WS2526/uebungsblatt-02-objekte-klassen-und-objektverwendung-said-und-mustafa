package de.phl.programmingproject.enrollmentsystem;

// Represents the enrollment of a student in a course with a grade
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
}