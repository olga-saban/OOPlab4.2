package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;
    private boolean graduated;

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    public Student(String email, String firstName, String lastName, String enrollmentDate, String dateOfBirth) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            this.enrollmentDate = format.parse(enrollmentDate);
            this.dateOfBirth = format.parse(dateOfBirth);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use yyyy-MM-dd");
            this.enrollmentDate = new Date();
            this.dateOfBirth = new Date();
        }
        this.graduated = false;
    }

    public String getEmail() { return email; }
    public boolean isGraduated() { return graduated; }
    public void graduate() { this.graduated = true; }
    public String shortInfo() {
        return firstName + " " + lastName + " (" + email + ")" + (graduated ? " [GRADUATED]" : "");
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", name='" + firstName + " " + lastName + '\'' +
                ", enrolled='" + format.format(enrollmentDate) + '\'' +
                ", birthDate='" + format.format(dateOfBirth) + '\'' +
                ", graduated=" + graduated +
                '}';
    }
}
