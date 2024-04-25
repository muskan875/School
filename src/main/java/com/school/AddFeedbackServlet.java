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
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/AddFeedback")
public class AddFeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFeedbackServlet() {
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
        String feedback = request.getParameter("feedback");
        String studentName = request.getParameter("studentName");
        // Insert feedback into database
        try (Connection conn = ConnectionUtil.getConnection();
        	     PreparedStatement stmt = conn.prepareStatement("INSERT INTO \"User\".\"feedback\" (studentName, feedback) VALUES (?, ?)")) {
        	    stmt.setString(1, studentName);
        	    stmt.setString(2, feedback);
        	    stmt.executeUpdate();
        	} catch (SQLException e) {
        	    e.printStackTrace();
        	    // Handle database errors
        	    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        	    return;
        	}

        // Set feedback data as request attribute
        request.setAttribute("feedback", feedback);
        request.setAttribute("studentName", studentName);
        // Forward the request to the JSP page to display feedback
        request.getRequestDispatcher("/Feedback.jsp").forward(request, response);
    }
}
