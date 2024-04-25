package com.school;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.util.ConnectionUtil;

@WebServlet("/userProfile")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the user ID from the request parameter
//        String userId = request.getParameter("id");
    	
    	HttpSession httpsession = request.getSession();
    	
    int id =(int )httpsession.getAttribute("id");

        // Create list to store user data
        String name = null;
        String email = null;
        String address = null;
        String gender = null;
        String dob = null;
        long mobileno = 0;
        // Database connection
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM \"User\".\"User\" WHERE id=?")) {
            pstmt.setInt(1, id);

            // Execute the query
            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if a user with the given ID exists
                if (rs.next()) {
                    // Retrieve user data from the result set
                    name = rs.getString("name");
                    email = rs.getString("email");
                   mobileno = rs.getLong("mobileno");
                    address = rs.getString("address");
                    gender = rs.getString("gender");
                    dob = rs.getString("dob");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (name != null && email != null && address != null && gender != null && dob != null && mobileno != 0) {
            // Set the user data as request attributes
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("address", address);
            request.setAttribute("gender", gender);
            request.setAttribute("dob", dob);
            request.setAttribute("mobileno", mobileno);

            // Forward the request to a JSP page for display
            RequestDispatcher dispatcher = request.getRequestDispatcher("UserProfile.jsp");
            dispatcher.forward(request, response);
        } else {
            // User with the given ID not found
            response.getWriter().println("User not found.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
