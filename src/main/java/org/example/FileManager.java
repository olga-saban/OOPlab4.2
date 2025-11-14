package org.example;
import java.io.*;

public class FileManager {
    private static final String FILE_NAME = "university.ser";

    public static void save(University university) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(university);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static University load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (University) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("!! No saved data found, starting new session. !!");
            return null;
        }
    }
}
