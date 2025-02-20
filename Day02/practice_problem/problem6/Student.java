package com.practiceproblems.problem6;
import org.json.JSONObject;

public class Student {
    public String id;
    public int marks;
    public String name;
    public int age;

    // Constructor
    public Student(){

    }
    public Student(String id, int marks, String name, int age) {
        this.id = id;
        this.marks = marks;
        this.name = name;
        this.age=age;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMarks() {
        return marks;
    }
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("marks", marks);
        jsonObject.put("name", name);
        jsonObject.put("age", age);
        return jsonObject;
    }
}
