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
import com.school.util.ConnectionUtil;

/**
 * Servlet implementation class EnquiryListServlet
 */
@WebServlet("/enquiryList")
public class EnquiryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EnquiryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		List<Enquiry> enquiryList = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"User\".\"enquiry\"");
             ResultSet rs = stmt.executeQuery()) {

            // Iterate over ResultSet and add feedback objects to list
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String role = rs.getString("role");
                long mobileno = rs.getLong("mobileno");

               
                Enquiry fb = new Enquiry(id, name, email,mobileno,role);
               enquiryList.add(fb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Return empty list if an error occurs
           enquiryList = new ArrayList<>();
        }

        // Convert list to JSON using Gson
        Gson gson = new Gson();
        String json = gson.toJson(enquiryList);

        // Set JSON data as a request attribute
        request.setAttribute("jsonData", json);

        // Forward the request to feedback.jsp
        request.getRequestDispatcher("EnquiryJson.jsp").forward(request, response);
     
    }
}
