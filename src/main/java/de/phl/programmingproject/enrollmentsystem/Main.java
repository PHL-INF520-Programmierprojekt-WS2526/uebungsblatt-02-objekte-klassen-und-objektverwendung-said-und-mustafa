package de.phl.programmingproject.enrollmentsystem;

public class Main {
    public static void main(String[] args) {
        // 1. Create student
        Student student = new Student("John Doe", "12345");

        // 2. Create course
        Course course1 = new Course("Introduction to Computer Science");

        // 3. Print info
        System.out.println(student.getInfo());
        System.out.println(course1.getInfo());

        // 4. Enroll student in course (creates Enrollment)
        student.enroll(course1);

        // Find the Enrollment object
        Enrollment enrollment1 = student.getEnrollments().stream()
                .filter(e -> e.getCourse().equals(course1))
                .findFirst().orElse(null);

        // 5. Print info again
        System.out.println(student.getInfo());
        System.out.println(course1.getInfo());

        // 6. Print enrollment info
        if (enrollment1 != null)
            System.out.println(enrollment1.getInfo());

        // 7. Set grade
        if (enrollment1 != null)
            enrollment1.setGrade(4.0);

        // 8. Print enrollment info again
        if (enrollment1 != null)
            System.out.println(enrollment1.getInfo());

        // 9. Create another course
        Course course2 = new Course("Object-Oriented Programming");

        // 10. Enroll student in the new course
        student.enroll(course2);

        // 11. Print list of courses the student is enrolled in
        System.out.println("Courses John is enrolled in:");
        for (Course c : student.getCourses()) {
            System.out.println(c.getInfo());
        }

        // 12. Print list of students in the first course
        System.out.println("Students enrolled in Introduction to Computer Science:");
        for (Student s : course1.getStudents()) {
            System.out.println(s.getInfo());
        }

        // 13. Drop the student from the first course
        student.drop(course1);

        // 14. Print list of students in the first course again
        System.out.println("Students enrolled in Introduction to Computer Science after dropping:");
        for (Student s : course1.getStudents()) {
            System.out.println(s.getInfo());
        }
    }
}