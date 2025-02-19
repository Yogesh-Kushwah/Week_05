package org.example.advance_problems.validate_csv_data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/advance_problems/validate_csv_data/Data.csv"; // Change this to your CSV file path

        // Define regex patterns
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";  // Valid email pattern
        String phoneRegex = "^[0-9]{10}$";  // 10-digit phone number pattern

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false; // Skip header row
                    continue;
                }

                String name = line[0];
                String email = line[1];
                String phone = line[2];

                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                if (!isEmailValid || !isPhoneValid) {
                    System.out.println("Invalid Record: " + String.join(", ", line));
                    if (!isEmailValid) {
                        System.out.println("  → Error: Invalid email format: " + email);
                    }
                    if (!isPhoneValid) {
                        System.out.println("  → Error: Invalid phone number (must be 10 digits): " + phone);
                    }
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
