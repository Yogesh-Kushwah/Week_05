package org.example.advance_problems.merge_2_Csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv"; // First CSV file (ID, Name, Age)
        String file2 = "students2.csv"; // Second CSV file (ID, Marks, Grade)
        String outputFile = "merged_students.csv"; // Output file

        Map<String, String[]> studentData = new HashMap<>();

        // Read first CSV (ID, Name, Age)
        try (CSVReader reader = new CSVReader(new FileReader(file1))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }
                studentData.put(line[0], line); // Store ID as key
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading " + file1 + ": " + e.getMessage());
        }

        // Read second CSV (ID, Marks, Grade) and merge data
        try (CSVReader reader = new CSVReader(new FileReader(file2))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String id = line[0];
                if (studentData.containsKey(id)) {
                    // Merge both records using ID
                    String[] studentInfo = studentData.get(id);
                    String[] mergedData = {studentInfo[0], studentInfo[1], studentInfo[2], line[1], line[2]};
                    studentData.put(id, mergedData);
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading " + file2 + ": " + e.getMessage());
        }

        // Write merged data to new CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            // Write header
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});

            // Write data
            for (String[] record : studentData.values()) {
                writer.writeNext(record);
            }

            System.out.println("Merged data written to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing " + outputFile + ": " + e.getMessage());
        }
    }
}
