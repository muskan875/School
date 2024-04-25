package com.school;

public class Student {
    private int id;
    private String name;
    private int hindi;
    private int english;
    private int maths;
    private int physics;
    private int chemistry;
    private int total;
    private int percentage;

    // Constructors, getters, and setters

    public Student() {
    }

    public Student(int id, String name, int hindi, int english, int maths, int physics, int chemistry, int total, int percentage) {
        this.id = id;
        this.name = name;
        this.hindi = hindi;
        this.english = english;
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
        this.total = total;
        this.percentage = percentage;
    }

    // Getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHindi() {
        return hindi;
    }

    public void setHindi(int hindi) {
        this.hindi = hindi;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
