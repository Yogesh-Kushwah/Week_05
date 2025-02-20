package com.practiceproblems.problem3;
public class Student{
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

    // toString() method for printing
    @Override
    public String toString() {
        return "Student{id='" + id + "', name='" + name + "', age='" + age + "', marks='" + marks + "'}";
    }
}
