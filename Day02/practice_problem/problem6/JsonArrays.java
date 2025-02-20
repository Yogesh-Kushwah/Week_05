package com.practiceproblems.problem6;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonArrays {
    public JSONArray makeArray(){
        Student student1=new Student("ID512",420,"Jojo",18);
        Student student2=new Student("ID513",400,"Gojo",23);
        Student student3=new Student("ID514",450,"Ken",21);
        JSONArray array= new JSONArray();
        array.put(student1.toJson());
        array.put(student2.toJson());
        array.put(student3.toJson());
        return array;
    }
    public static void main(String args[]){
        JsonArrays json=new JsonArrays();
        JSONArray array=json.makeArray();
        System.out.println(array.toString());


    }
}
