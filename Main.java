package de.phl.programmingproject.enrollmentsystem;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("John Doe", "12345");
        Course course1 = new Course("Introduction to Computer Science");

        System.out.println("=== Schritt 3: Anfangsinformationen ===");
        System.out.println(student.getInfo());
        System.out.println(course1.getInfo());
        System.out.println();

        Enrollment enrollment1 = student.enroll(course1);

        System.out.println("=== Schritt 5: Nach der Einschreibung ===");
        System.out.println(student.getInfo());
        System.out.println(course1.getInfo());
        System.out.println();

        System.out.println("=== Schritt 6: Enrollment-Informationen ===");
        System.out.println(enrollment1.getInfo());
        System.out.println();

        enrollment1.setGrade(4.0);

        System.out.println("=== Schritt 8: Aktualisierte Enrollment-Informationen ===");
        System.out.println(enrollment1.getInfo());
        System.out.println();

        Course course2 = new Course("Object-Oriented Programming");
        student.enroll(course2);

        System.out.println("=== Schritt 11: Alle Kurse des Studenten ===");
        student.getCourses().forEach(c -> System.out.println(" - " + c.getName()));
        System.out.println();

        System.out.println("=== Schritt 12: Studierende im Kurs '" + course1.getName() + "' ===");
        course1.getStudents().forEach(s -> System.out.println(" - " + s.getName()));
        System.out.println();

        student.drop(course1);

        System.out.println("=== Schritt 14: Studierende nach dem Austragen ===");
        course1.getStudents().forEach(s -> System.out.println(" - " + s.getName()));
        System.out.println();

        System.out.println("=== Fertig! Das Enrollment-System funktioniert korrekt. ===");
    }
}
