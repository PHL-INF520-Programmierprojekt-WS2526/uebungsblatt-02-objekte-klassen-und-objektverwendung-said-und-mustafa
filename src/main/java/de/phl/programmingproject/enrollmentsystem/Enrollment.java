package de.phl.programmingproject.enrollmentsystem;

// Repräsentiert die Einschreibung eines Studenten in einen Kurs mit Note
public class Enrollment {
    private final Student student;
    private final Course course;
    private double grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = 0.0; // Standardwert
    }

    public String getInfo() {
        return "Student: " + student.getName() + ", Kurs: " + course.getName() + ", Note: " + grade;
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
