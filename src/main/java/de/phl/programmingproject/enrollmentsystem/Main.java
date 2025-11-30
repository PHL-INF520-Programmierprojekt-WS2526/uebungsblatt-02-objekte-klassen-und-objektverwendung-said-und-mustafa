package de.phl.programmingproject.enrollmentsystem;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("John Doe", "12345");
        Course course1 = new Course("Introduction to Computer Science");

        System.out.println(student.getInfo());
        System.out.println(course1.getInfo());

        // Enroll
        student.enroll(course1);

        Enrollment enrollment1 = student.getEnrollments().stream()
                .filter(e -> e.getCourse().equals(course1))
                .findFirst().orElse(null);

        System.out.println(student.getInfo());
        System.out.println(course1.getInfo());

        if (enrollment1 != null)
            System.out.println(enrollment1.getInfo());

        if (enrollment1 != null)
            enrollment1.setGrade(4.0);

        if (enrollment1 != null)
            System.out.println(enrollment1.getInfo());

        Course course2 = new Course("Object-Oriented Programming");
        student.enroll(course2);

        // Test 11: John is enrolled in OOP
        System.out.println("Courses John is enrolled in:");
        for (Course c : student.getCourses()) {
            System.out.println(c.getInfo());
        }

        // Test 12: Liste der Studenten im ersten Kurs
        System.out.println("Students enrolled in Introduction to Computer Science:");
        for (Student s : course1.getStudents()) {
            System.out.println(s.getInfo());
        }

        // Drop
        student.drop(course1);

        // Test 14: Liste nach drop
        System.out.println("Students enrolled in Introduction to Computer Science after dropping:");
        for (Student s : course1.getStudents()) {
            System.out.println(s.getInfo());
        }
    }
}