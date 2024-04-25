package com.school;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.util.ConnectionUtil;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("id");

	        // Perform deletion logic here
	        boolean deletionSuccessful_user= deleteRowFromUser(id);
	        boolean deletionSuccessful_notice = deleteRowFromNotice(id);
	        boolean deletionSuccessful_marksheet = deleteRowFromMarksheet(id);
	        boolean deletionSuccessful_Feedback = deleteRowFromFeedback(id);
	        boolean deletionSuccessful_enquiry = deleteRowFromEnquiry(id);
	        boolean deletionSuccessful_subjects = deleteRowFromSubjects(id);
	        

	        if (deletionSuccessful_user) {
	          //  response.sendRedirect("EnquiryJson.jsp");
	            response.getWriter().println(" delete record.");
	        } else if(deletionSuccessful_notice) {
	            // Handle deletion failure, e.g., display an error message
	        	response.sendRedirect(request.getContextPath() + "/noticeServlet?");
	        }else if(deletionSuccessful_marksheet) {
	            // Handle deletion failure, e.g., display an error message 
	        	response.sendRedirect(request.getContextPath() + "/result?");
	        }else if(deletionSuccessful_Feedback) {
	            // Handle deletion failure, e.g., display an error message 
	        	response.sendRedirect(request.getContextPath() + "/FeedbackListSer?");
	        }else if(deletionSuccessful_enquiry) {
	            // Handle deletion failure, e.g., display an error message
	        	response.sendRedirect(request.getContextPath() + "/enquiryList?");
	        	
	        }else if(deletionSuccessful_subjects) {
	            // Handle deletion failure, e.g., display an error message 
	        	response.sendRedirect(request.getContextPath() + "/subjectList?");
	        }
	        else
	        	
	        {
	        	response.getWriter().println("delete record.");}
	        

	    }

	    private boolean deleteRowFromUser(String id) {
	        try {
	            // Create a connection to the database using ConnectionUtil
	            Connection connection = ConnectionUtil.getConnection();

	            // Prepare SQL statement to delete the row based on the ID
	            String sql = "DELETE FROM \"User\".\"User\" WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, Integer.parseInt(id));

	            // Execute the delete statement
	            int rowsAffected = statement.executeUpdate();

	            // Close resources
	            statement.close();
	            connection.close();

	            // Return true if deletion was successful (i.e., rowsAffected > 0)
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	
	    
	    private boolean deleteRowFromNotice(String id) {
	        try {
	            // Create a connection to the database using ConnectionUtil
	            Connection connection = ConnectionUtil.getConnection();

	            // Prepare SQL statement to delete the row based on the ID
	            String sql = "DELETE FROM \"User\".\"Notice\" WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, Integer.parseInt(id));

	            // Execute the delete statement
	            int rowsAffected = statement.executeUpdate();

	            // Close resources
	            statement.close();
	            connection.close();

	            // Return true if deletion was successful (i.e., rowsAffected > 0)
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    private boolean deleteRowFromEnquiry(String id) {
	        try {
	            // Create a connection to the database using ConnectionUtil
	            Connection connection = ConnectionUtil.getConnection();

	            // Prepare SQL statement to delete the row based on the ID
	            String sql = "DELETE FROM \"User\".\"enquiry\" WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, Integer.parseInt(id));

	            // Execute the delete statement
	            int rowsAffected = statement.executeUpdate();

	            // Close resources
	            statement.close();
	            connection.close();

	            // Return true if deletion was successful (i.e., rowsAffected > 0)
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    private boolean deleteRowFromFeedback(String id) {
	        try {
	            // Create a connection to the database using ConnectionUtil
	            Connection connection = ConnectionUtil.getConnection();

	            // Prepare SQL statement to delete the row based on the ID
	            String sql = "DELETE FROM \"User\".\"feedback\" WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, Integer.parseInt(id));

	            // Execute the delete statement
	            int rowsAffected = statement.executeUpdate();

	            // Close resources
	            statement.close();
	            connection.close();

	            // Return true if deletion was successful (i.e., rowsAffected > 0)
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	    
	    private boolean deleteRowFromMarksheet(String id) {
	        try {
	            // Create a connection to the database using ConnectionUtil
	            Connection connection = ConnectionUtil.getConnection();

	            // Prepare SQL statement to delete the row based on the ID
	            String sql = "DELETE FROM \"User\".\"marksheet\" WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, Integer.parseInt(id));

	            // Execute the delete statement
	            int rowsAffected = statement.executeUpdate();

	            // Close resources
	            statement.close();
	            connection.close();

	            // Return true if deletion was successful (i.e., rowsAffected > 0)
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    
	    private boolean deleteRowFromSubjects(String id) {
	        try {
	            // Create a connection to the database using ConnectionUtil
	            Connection connection = ConnectionUtil.getConnection();

	            // Prepare SQL statement to delete the row based on the ID
	            String sql = "DELETE FROM \"User\".\"subjects\" WHERE id = ?";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, Integer.parseInt(id));

	            // Execute the delete statement
	            int rowsAffected = statement.executeUpdate();

	            // Close resources
	            statement.close();
	            connection.close();

	            // Return true if deletion was successful (i.e., rowsAffected > 0)
	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
