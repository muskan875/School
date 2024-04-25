package com.school;

public class User {

	private int id;
    private String name;
    private String email;
    private String address;
    private String dob;
    private String gender;
    private long mobileno;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

//    public User(int  id, String name, String email) {
//    	this.id = id;
//    	this.name=name;
//    	this.email=email;
//    	
//    }

	public User(int id, String name, String email, String address, String gender, String dob, long mobileno) {
		this.id = id;
		this.name=name;
    	this.email=email;
    	this.address=address;
    	this.dob=dob;
    	this.gender=gender;
    	this.mobileno=mobileno;
    	
	}

	
}
