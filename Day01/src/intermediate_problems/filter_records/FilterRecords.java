package org.example.intermediate_problems.filter_records;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        try (CSVReader csvReader = new CSVReader(new FileReader("src/main/java/org/example/intermediate_problems/filter_records/Marks.csv"))) {

            String[] line;
            boolean isHeader = true; // To skip header

            while ((line = csvReader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;  // Skip the first row (header)
                    continue;
                }

                int marks = Integer.parseInt(line[2]); // Convert marks to integer

                if (marks > 80) {  // Print only if marks > 80
                    System.out.println(" Name: " + line[0] + "  Age: " + line[1] + "  Marks: " + line[2] + "  City: " + line[3]);
                }
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
