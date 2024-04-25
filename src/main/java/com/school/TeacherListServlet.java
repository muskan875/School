package com.school;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebServlet("/TeacherListServlet")
//public class TeacherListServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    public TeacherListServlet() {
//        super();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<User> teacherList = getTeacherListFromDatabase();
//     
//        request.setAttribute("teacherList", teacherList);
//        request.getRequestDispatcher("teacherList.jsp").forward(request, response);
//        
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Handle any POST requests here if needed
//    }
//
//    private List<User> getTeacherListFromDatabase() {
//        List<User> teacherList = new ArrayList<>();
//        try {
//            Connection connection = Config.getcon();
//            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"User\".\"User\"");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String email = rs.getString("email");
//                String address = rs.getString("address");
//                String dob = rs.getString("dob");
//                String gender = rs.getString("gender");
//                long mobileno = rs.getLong("mobileno");
//                User teacher = new User(id, name,email,mobileno,address,dob,gender);
//                teacherList.add(teacher);
//                
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return teacherList;
//    }
//}

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
import com.school.util.ConnectionUtil;

@WebServlet("/teacherList")
public class TeacherListServlet extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 List<User> teacherList = new ArrayList<>();

         try (Connection conn = ConnectionUtil.getConnection();
              PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"User\".\"User\" where userrole='teacher'");
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
                teacherList.add(fb);
             }
         } catch (SQLException e) {
             e.printStackTrace();
             // Return empty list if an error occurs
            teacherList = new ArrayList<>();
         }

         // Convert list to JSON using Gson
         Gson gson = new Gson();
         String json = gson.toJson(teacherList);

         // Set JSON data as a request attribute
         request.setAttribute("jsonData", json);

         // Forward the request to feedback.jsp
         request.getRequestDispatcher("TeacherJson.jsp").forward(request, response);
      
     }
 }
