package org.example.basic_problems.read_print_data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadPrintData {
    public static void main(String[] args) {

        String filePath="src/main/java/org/example/read_print_data/Reading.csv";

        try(BufferedReader br= new BufferedReader(new FileReader(filePath))){

            String line;

            while((line= br.readLine()) !=null){

                String[] columns=line.split(",");
                System.out.println(columns[0]+"   "+columns[1]+"    "+columns[2]);
            }
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
    }

}
