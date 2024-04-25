package com.school;

public class Enquiry {
    private int id;
    private String name;
    private String email;
    private long mobileno;
    private String role;

    // Constructor
    public Enquiry(int id, String name, String email, long mobileno, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileno = mobileno;
        this.role = role;
    }

    // Getters and Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
