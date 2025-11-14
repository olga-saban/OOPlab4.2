package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class University implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Map<String, Faculty> faculties = new HashMap<>();
    private transient static final Scanner scanner = new Scanner(System.in);

    public void createFaculty() {
        System.out.print("Faculty name: ");
        String name = scanner.nextLine();
        System.out.print("Abbreviation: ");
        String abbr = scanner.nextLine();

        System.out.println("Choose field:");
        for (StudyField f : StudyField.values())
            System.out.println(" - " + f);
        System.out.print("Enter: ");
        StudyField field = StudyField.valueOf(scanner.nextLine().toUpperCase());

        addFaculty(new Faculty(name, abbr, field));
    }
    public void addFaculty(Faculty f) {
        if (faculties.containsKey(f.getAbbreviation().toUpperCase())) {
            System.out.println("Faculty " + f.getAbbreviation() + " already exists!");
            return;
        }
        faculties.put(f.getAbbreviation().toUpperCase(), f);
        System.out.println("Faculty " + f.getAbbreviation() + " created!");
    }
    public Faculty findFaculty(String abbr) {
        return faculties.get(abbr.toUpperCase());
    }
    public void displayFaculties() {
        if (faculties.isEmpty()) {
            System.out.println("No faculties created yet.");
            return;
        }
        System.out.println("Faculties:");
        faculties.values().forEach(System.out::println);
    }
    public void createStudentAndAssign() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("First name: ");
        String fn = scanner.nextLine();
        System.out.print("Last name: ");
        String ln = scanner.nextLine();
        System.out.print("Enroll date: ");
        String ed = scanner.nextLine();
        System.out.print("Birth date: ");
        String bd = scanner.nextLine();

        System.out.print("Faculty abbreviation: ");
        String abbr = scanner.nextLine();

        Student s = new Student(email, fn, ln, ed, bd);
        addStudentToFaculty(s, abbr);
    }
    public void addStudentToFaculty(Student s, String facultyAbbr) {
        Faculty f = findFaculty(facultyAbbr);
        if (f != null) f.addStudent(s);
        else System.out.println("Faculty " + facultyAbbr + " not found!");
    }
    public void graduateStudent(String email) {
        for (Faculty f : faculties.values()) {
            for (Student s : f.getStudents()) {
                if (s.getEmail().equalsIgnoreCase(email)) {
                    s.graduate();
                    System.out.println("Student " + email + " graduated!");
                    return;
                }
            }
        }
        System.out.println("No such student.");
    }
    public void listStudentsOfFaculty() {
        System.out.print("Faculty abbreviation: ");
        String abbr = scanner.nextLine();
        Faculty f = findFaculty(abbr);
        if (f != null) f.listStudents();
        else System.out.println("No such faculty.");
    }
    public void searchStudent() {
        System.out.print("Student email: ");
        String email = scanner.nextLine().trim().toLowerCase();
        for (Faculty f : faculties.values()) {
            for (Student s : f.getStudents()) {
                if (s.getEmail().equalsIgnoreCase(email)) {
                    System.out.println("Found: " + s);
                    return;
                }
            }
        }
        System.out.println("No such student.");
    }
    public void displayAllStudents() {
        if (faculties.isEmpty()) {
            System.out.println("No faculties available.");
            return;
        }
        for (Faculty f : faculties.values()) {
            System.out.println("\t" + f.getAbbreviation());
            f.listStudents();
        }
    }
}
