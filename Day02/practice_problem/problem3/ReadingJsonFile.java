package com.practiceproblems.problem3;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class ReadingJsonFile {
    public void readJson(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            Student student = mapper.readValue(new File("student.json"), Student.class);
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student Name: " + student.getName());
        } catch (Exception e) {
            System.out.println("Exception Caught :" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReadingJsonFile read = new ReadingJsonFile();
        read.readJson();
    }
}
