package com.example.Student.model;

public class Student {
    private String name;
    private int ID;
    private int age;

    public Student(){

    }

    public Student(String name, int ID, int age){
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getID(){
        return ID;
    }

}
