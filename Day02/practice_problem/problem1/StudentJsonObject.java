package com.practiceproblems.problem1;
import org.json.*;
public class StudentJsonObject {
    public JSONObject createJsonObject(){
        JSONObject student= new JSONObject();
        student.put("name","Khushi Verma");
        student.put("age",22);
        student.put("subjects",new String[]{"C++","Java","DSA"});
        return student;
    }
    public static void main(String args[]){
        StudentJsonObject jsonObject=new StudentJsonObject();
        JSONObject student=jsonObject.createJsonObject();
        System.out.println(student.toString());
    }
}
