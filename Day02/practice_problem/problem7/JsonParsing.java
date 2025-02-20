package com.practiceproblems.problem7;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
public class JsonParsing {
    public void parseJson(){
        try{
            ObjectMapper mapper = new ObjectMapper(); // Create ObjectMapper instance
            JsonNode rootNode = mapper.readTree(new File("student1.json")); // Read JSON file into JsonNode
            if (rootNode.isArray()) { // Check if root node is an array
                for (JsonNode node : rootNode) {// Iterate through each element in the array
                    JsonNode ageNode = node.get("Age");
                    if (ageNode != null) { // Check if 'age' field exists
                        int age = ageNode.asInt(); // Extract 'age' field
                        if (age > 25) { // Check if age is greater than 25
                            JsonNode nameNode = node.get("Name");
                            if (nameNode != null) { // Check if 'name' field exists
                                System.out.println(nameNode.asText()); // Print 'name' field
                            } else {
                                System.out.println("Name field is missing for one of the students.");
                            }
                        }
                    } else {
                        System.out.println("Age field is missing for one of the students.");
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println("Caught Exception :" +e.getMessage());
        }
    }
    public static void main(String args[]){
        JsonParsing parse=new JsonParsing();
        parse.parseJson();
    }
}
