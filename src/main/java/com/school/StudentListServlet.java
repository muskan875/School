package com.school;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.school.util.*;

@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 List<User> studentList = new ArrayList<>();

         try (Connection conn = ConnectionUtil.getConnection();
              PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"User\".\"User\" where userrole='student'");
              ResultSet rs = stmt.executeQuery()) {

             // Iterate over ResultSet and add feedback objects to list
             while (rs.next()) {
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 String email = rs.getString("email");
                 String address = rs.getString("address");
                 String dob = rs.getString("dob");
                 String gender = rs.getString("gender");
                 long mobileno = rs.getLong("mobileno");
                 
      
                
                 User fb = new User(id, name, email, address, dob, gender, mobileno);
                studentList.add(fb);
             }
         } catch (SQLException e) {
             e.printStackTrace();
             // Return empty list if an error occurs
            studentList = new ArrayList<>();
         }

         // Convert list to JSON using Gson
         Gson gson = new Gson();
         String json = gson.toJson(studentList);

         // Set JSON data as a request attribute
         request.setAttribute("jsonData", json);

         // Forward the request to feedback.jsp
         request.getRequestDispatcher("StudentJson.jsp").forward(request, response);
      
     }
 }
