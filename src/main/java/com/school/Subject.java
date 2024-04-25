package com.school;

public class Subject {

    private String name;
    private int code;
    private int id; // Assuming you've added this field

    public Subject(int id,String name, int code) {
    	this.id = id;
        this.name = name;
        this.code = code;
    }

    // Getter and setter methods for 'name' field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for 'code' field
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // Getter and setter methods for 'id' field
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}

