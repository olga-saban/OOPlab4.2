package org.example;
import java.util.Scanner;

import static org.example.Logger.*;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static University TUM;

    public static void main(String[] args) {
        TUM = FileManager.load();
        if (TUM == null) {
            TUM = new University();
            log("Started new University instance (no saved data)");
        }

        while (true) {
            System.out.println("\t\nTUM Student Management");
            System.out.println("1. Create faculty");
            System.out.println("2. Create student and assign to faculty");
            System.out.println("3. Graduate a student");
            System.out.println("4. Display all faculties");
            System.out.println("5. Display students of a faculty");
            System.out.println("6. Search student by email");
            System.out.println("7. Display all students");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            String opt = scanner.nextLine().trim();

            switch (opt) {
                case "1": {
                    TUM.createFaculty();
                    break;
                }
                case "2": TUM.createStudentAndAssign(); break;
                case "3": {
                    System.out.print("Enter student email: ");
                    String email = scanner.nextLine();
                    TUM.graduateStudent(email);
                    break;
                }
                case "4": TUM.displayFaculties(); break;
                case "5": TUM.listStudentsOfFaculty(); break;
                case "6": TUM.searchStudent(); break;
                case "7": TUM.displayAllStudents(); break;
                case "0": {
                    FileManager.save(TUM);
                    System.out.println("Bye.");
                    return;
                }
                default: System.out.println("Unknown option. Try again.");  break;
            }
        }
    }
}
