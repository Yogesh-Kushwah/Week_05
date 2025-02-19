package org.example.basic_problems.read_count_row;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCountRows {
    public static void main(String[] args) {

        String line;
        int count=0;
        try(BufferedReader bf= new BufferedReader ( new FileReader("src/main/java/org/example/read_count_rows/Read.csv"))){

            boolean isHeader=true;
            while((line= bf.readLine()) !=null){

                if(isHeader){
                    isHeader= false;
                    continue;
                }

              count++;

            }

            System.out.println(count-1);


        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
