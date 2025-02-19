package org.example.basic_problems.write_data_csv;

import java.io.FileWriter;
import java.io.IOException;

public class WriteDataCSV {
    public static void main(String[] args) {

        try (FileWriter fileWriter = new FileWriter("src/main/java/org/example/write_data_csv/write.csv")) {

            fileWriter.write("ID,Name,Department,Salary\n");

            fileWriter.write("101, Vivek ,Finance,62000\n");
            fileWriter.write("102, Puravansh ,Sales,58000\n");
            fileWriter.write("103,  Harsh,Finance,62000\n");
            fileWriter.write("104,Satyam,Sales,58000\n");
            fileWriter.write("105,Ajeet Raj,Finance,62000\n");
            fileWriter.write("106,Karan ,Sales,58000\n");

            System.out.println("Csv file written Successfully");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}