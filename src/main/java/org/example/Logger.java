package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    private static final String LOG_FILE = "log.txt";

    public static void log(String msg) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            fw.write("[" + new Date() + "] " + msg + "\n");
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }
}
