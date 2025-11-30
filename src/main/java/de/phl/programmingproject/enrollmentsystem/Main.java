package de.phl.programmingproject.enrollmentsystem;

public class Main {
    public static void main(String[] args) {
        // 1. Student erstellen
        Student student = new Student("John Doe", "12345");

        // 2. Course erstellen
        Course course1 = new Course("Introduction to Computer Science");

        // 3. Infos ausgeben
        System.out.println(student.getInfo());
        System.out.println(course1.getInfo());

        // 4. Student in Kurs einschreiben
        student.enroll(course1);

        // Enrollment finden
        Enrollment enrollment1 = student.getEnrollments().stream()
                .filter(e -> e.getCourse().equals(course1))
                .findFirst().orElse(null);

        // 5. Infos nach Einschreibung ausgeben
        System.out.println(student.getInfo());
        System.out.println(course1.getInfo());

        // 6. Enrollment-Info ausgeben
        if (enrollment1 != null)
            System.out.println(enrollment1.getInfo());

        // 7. Note setzen
        if (enrollment1 != null)
            enrollment1.setGrade(4.0);

        // 8. Enrollment-Info erneut ausgeben
        if (enrollment1 != null)
            System.out.println(enrollment1.getInfo());

        // 9. Weiteren Kurs erstellen
        Course course2 = new Course("Object-Oriented Programming");

        // 10. Student in neuen Kurs einschreiben
        student.enroll(course2);

        // 11. Liste der Kurse
        System.out.println("Courses John is enrolled in:");
        for (Course c : student.getCourses()) {
            System.out.println(c.getInfo());
        }

        // 12. Liste der Studenten im ersten Kurs
        System.out.println("Students enrolled in Introduction to Computer Science:");
        for (Student s : course1.getStudents()) {
            System.out.println(s.getInfo());
        }

        // 13. Student aus erstem Kurs austragen
        student.drop(course1);

        // 14. Liste der Studenten nach Austragung
        System.out.println("Students enrolled in Introduction to Computer Science after dropping:");
        for (Student s : course1.getStudents()) {
            System.out.println(s.getInfo());
        }
    }
}