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
 * Servlet implementation class UpdateFeedbackServlet
 */
 @WebServlet("/UpdateFeedbackSer")
public class UpdateFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFeedbackServlet() {
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
		    String feedback = request.getParameter("feedback");

		    // Ensure that id is not null before parsing it
		    int userId = id != null && !id.isEmpty() ? Integer.parseInt(id) : 0;

		    boolean updateSuccessful = updateFeedback(userId, feedback);
		    if (updateSuccessful) {
		    	response.sendRedirect(request.getContextPath() + "/FeedbackListSer?");
		    } else {
		    	response.sendRedirect(request.getContextPath() + "/FeedbackListSer?errorMsg=Failed to update record");
		    }
		}

	    private boolean updateFeedback(int id, String feedback) {
	       
	        	try {
	                Connection connection = ConnectionUtil.getConnection();
	                // Enclose schema and table name in double quotes and use proper casing
	                String sql = "UPDATE \"User\".\"feedback\" SET feedback = ? WHERE id = ?";
	                PreparedStatement statement = connection.prepareStatement(sql);
	                statement.setString(1, feedback);
	                statement.setInt(2, id); // Correct index for the id parameter

	                int rowsAffected = statement.executeUpdate();

	                statement.close();
	                connection.close();

	                return rowsAffected > 0;
	            } catch (SQLException e) {
	                e.printStackTrace();
	                return false;
	            }
	        }
}

