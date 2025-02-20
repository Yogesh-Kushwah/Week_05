package com.practiceproblems.problem2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
public class JsonFromObject {
    public String jsonFromObject(){
        String jsonString="";
        try{
            ObjectMapper mapper=new ObjectMapper();
            Car car1 = new Car("BMW", "I8", "MP-04-2023", 100000000);
            jsonString = mapper.writeValueAsString(car1);
        }
        catch(Exception e){
            System.out.println("Exception Caught: "+e.getMessage());
        }
        return jsonString;
    }
    public static void main(String args[]){
        JsonFromObject object=new JsonFromObject();
        String carDetails=object.jsonFromObject();
        System.out.println(carDetails);
    }
}
