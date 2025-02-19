package org.example.advance_problems.csv_data_object;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Student class representing each CSV row
class Student {
    private String name;
    private int age;
    private double marks;

    public Student(String name, int age, double marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", marks=" + marks + "}";
    }
}

public class CSVToStudentObject {
    public static void main(String[] args) {
        String filePath = "students.csv"; // Path to CSV file
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                // Extract values from CSV
                String name = line[0];
                int age = Integer.parseInt(line[1]);
                double marks = Double.parseDouble(line[2]);

                // Create Student object and add to list
                students.add(new Student(name, age, marks));
            }

        } catch (IOException | CsvValidationException | NumberFormatException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        // Print all student objects
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
