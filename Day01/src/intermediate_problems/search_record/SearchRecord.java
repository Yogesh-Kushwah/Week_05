package org.example.intermediate_problems.search_record;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class SearchRecord {
    public static void main(String[] args) {

        try (CSVReader csvReader = new CSVReader(new FileReader("src/main/java/org/example/intermediate_problems/search_record/employees.csv"));
             Scanner scanner = new Scanner(System.in)) {

            HashSet<String> namesToSearch = new HashSet<>();
            List<String> matchedRecords = new ArrayList<>();
            int count = 0;

            // Taking multiple names as input
            while (true) {
                System.out.print("Enter employee name to search: ");
                String name = scanner.nextLine().toLowerCase();  // Convert input to lowercase for case-insensitive search
                namesToSearch.add(name);
                count++;

                System.out.print("Want to Exit? [Y/N]: ");
                String choice = scanner.next();
                scanner.nextLine(); // Consume newline
                if (choice.equalsIgnoreCase("Y") || count == 11) {
                    break;
                }
            }

            String[] line;
            boolean found = false;

            // Reading CSV file and checking for matches
            while ((line = csvReader.readNext()) != null) {
                if (namesToSearch.contains(line[0].toLowerCase())) { // Case-insensitive comparison
                    found = true;
                    String record = "Name: " + line[0] + " | Age: " + line[1] + " | Marks: " + line[2] + " | City: " + line[3];
                    matchedRecords.add(record);
                }
            }

            // Printing all matched records
            if (found) {
                System.out.println("\nMatched Records:");
                for (String record : matchedRecords) {
                    System.out.println(record);
                }
            } else {
                System.out.println("\nNo matching records found.");
            }

        } catch (CsvValidationException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
