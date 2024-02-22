package com.epam.mjc.nio;
import java.io.*;


public class FileReader {
    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String name = null;
            int age = 0;
            String email = null;
            Long phone = null;

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    name = line.substring("Name:".length()).trim();
                } else if (line.startsWith("Age:")) {
                    age = Integer.parseInt(line.substring("Age:".length()).trim());
                } else if (line.startsWith("Email:")) {
                    email = line.substring("Email:".length()).trim();
                } else if (line.startsWith("Phone:")) {
                    phone = Long.parseLong(line.substring("Phone:".length()).trim());
                }
            }
            return new Profile(name, age, email,phone);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}