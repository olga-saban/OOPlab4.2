package org.example;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Faculty  implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String abbreviation;
    private final StudyField studyField;
    private final List<Student> students = new ArrayList<>();

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation.toUpperCase();
        this.studyField = studyField;
    }
    public String getAbbreviation() { return abbreviation; }
    public List<Student> getStudents() { return students; }
    public void addStudent(Student s) {
        students.add(s);
        System.out.println("Added " + s.shortInfo() + " to " + abbreviation);
    }
    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled in " + abbreviation);
            return;
        }
        System.out.println("Students of " + abbreviation + ":");
        students.forEach(s -> System.out.println(" - " + s.shortInfo()));
    }

    @Override
    public String toString() {
        return abbreviation + " | " + name + " | Field: " + studyField;
    }
}
