package org.example.intermediate_problems.modify_csv_file;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class UpdateSalaryCSV {
    public static void main(String[] args) {

        String inputfilepath = "src/main/java/org/example/intermediate_problems/modify_csv_file/EmployeeOldSalary.csv";
        String outputFilePath = "src/main/java/org/example/intermediate_problems/modify_csv_file/ITEmployee.csv";

        try (
                // Open the original CSV file for reading
                CSVReader reader = new CSVReader(new FileReader("employees.csv"));
                // Create a new CSV file for writing updated data
                CSVWriter writer = new CSVWriter(new FileWriter("updated_employees.csv"))
        ) {
            String[] line;

            // Read each line (row) from the CSV file
            while ((line = reader.readNext()) != null) {

                // Check if the employee belongs to the "IT" department
                if (line[2].equalsIgnoreCase("IT")) {
                    // Parse current salary from the CSV (column index 3)
                    double salary = Double.parseDouble(line[3]);

                    // Increase salary by 10%
                    salary *= 1.10;

                    // Convert the updated salary ,formating back to a string
                    line[3] = String.format("%.2f", salary);
                }

                // Write the  row to the new CSV file
                writer.writeNext(line);
            }

            System.out.println("Salary updated successfully.");
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }}