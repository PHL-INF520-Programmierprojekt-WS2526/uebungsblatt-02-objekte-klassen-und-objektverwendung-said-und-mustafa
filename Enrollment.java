package de.phl.programmingproject.enrollmentsystem;

public class Enrollment {
    private Student student;
    private Course course;
    private Double grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = null;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getInfo() {
        return student.getName() + " enrolled in " + course.getName() + 
               (grade != null ? " - Grade: " + grade : "");
    }
}
