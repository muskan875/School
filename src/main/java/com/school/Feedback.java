package com.school;

public class Feedback {
private int id;
private String studentName;
private String feedback;
public Feedback() {
    // Default constructor
}

public Feedback(int id,String studentName, String feedback) {
    this.id = id;
    this.feedback = feedback;
    this.studentName = studentName;
}

// Getter and setter methods for id
public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

// Getter and setter methods for feedback
public String getFeedback() {
    return feedback;
}

public void setFeedback(String feedback) {
    this.feedback = feedback;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}


}
