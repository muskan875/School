package com.school;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.util.ConnectionUtil;

/**
 * Servlet implementation class UpdateEnquiryServlet
 */
@WebServlet("/UpdateEnquirySer")
public class UpdateEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEnquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String id = request.getParameter("id");
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String mobile = request.getParameter("mobile");
	       
	        String role = request.getParameter("role");
	       
	        
	        // Ensure that id and mobile are not null before parsing them
	        int userId = id != null && !id.isEmpty() ? Integer.parseInt(id) : 0;
	        long mobileNo = mobile != null && !mobile.isEmpty() ? Long.parseLong(mobile) : 0;

	        // Retrieve other form fields like address, email, dob, gender, password, etc.

	        boolean updateSuccessful = updateUser(userId, name, email, mobileNo,role);
	        if (updateSuccessful) {
	        	response.sendRedirect(request.getContextPath() + "/enquiryList?");
	        } else {
	        	response.sendRedirect(request.getContextPath() + "/enquiryList?errorMsg=Failed to update record");
	        }
	    }

	    private boolean updateUser(int id, String name, String email, long mobile,  String role) {
	        try {
	            Connection connection = ConnectionUtil.getConnection();
	            // Enclose schema and table name in double quotes and use proper casing
	            String sql = "UPDATE \"User\".\"enquiry\" SET name = ?, email = ?, mobileno = ?,role = ? WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, name); 
	            statement.setString(2, email);
	            statement.setLong(3, mobile);       
	            statement.setString(4, role);
	            statement.setInt(5, id);

	            int rowsAffected = statement.executeUpdate();

	            statement.close();
	            connection.close();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }}


