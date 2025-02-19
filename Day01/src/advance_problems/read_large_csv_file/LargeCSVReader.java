package org.example.advance_problems.read_large_csv_file;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "src/main/java/org/example/advance_problems/read_large_csv_file/large_dataset.csv"; // CSV file path
        int batchSize = 100; // Process 100 lines at a time
        int totalRecords = 0, batchCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) { isHeader = false; continue; } // Skip header

                totalRecords++;
                batchCount++;

                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records...");
                    batchCount = 0; // Reset batch counter
                }
            }
            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
