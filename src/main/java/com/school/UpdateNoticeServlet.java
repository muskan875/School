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
import javax.servlet.http.HttpSession;

import com.school.util.ConnectionUtil;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/UpdateNoticeSer")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
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
//		String id = request.getParameter("id");
//        String notice = request.getParameter("notice");
//     
//        int userId = id != null && !id.isEmpty() ? Integer.parseInt(id) : 0;
//   
//
//        boolean updateSuccessful = updateNotice(userId, notice);
//        if (updateSuccessful) {
//        	// response.getWriter().println(" Updated record.");
//        	 response.sendRedirect(request.getContextPath() + "/noticeServlet?");
//        } else {
//        	 response.getWriter().println("record Not Updated.");
//        	 response.sendRedirect(request.getContextPath() + "/noticeServlet?errorMsg=Failed to update record");
//        }
//    }
		
		HttpSession session = request.getSession();
        String userRole = (String) session.getAttribute("userRole");

        if (userRole != null && userRole.equalsIgnoreCase("admin")) {
            // Only admins can update or delete the data
            String id = request.getParameter("id");
            String notice = request.getParameter("notice");
         
            int noticeId = id != null && !id.isEmpty() ? Integer.parseInt(id) : 0;
       
            boolean updateSuccessful = updateNotice(noticeId, notice);
            if (updateSuccessful) {
                // Redirect to the notice list page after successful update
                response.sendRedirect(request.getContextPath() + "/noticeServlet");
            } else {
                // Redirect with error message if update fails
                response.sendRedirect(request.getContextPath() + "/noticeServlet?errorMsg=Failed to update record");
            }
        } else {
            // If the user is not an admin, redirect them to a permission denied page
            response.sendRedirect(request.getContextPath() + "/Login.jsp");
        }
    }

    private boolean updateNotice(int id, String notice) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            // Enclose schema and table name in double quotes and use proper casing
            String sql = "UPDATE \"User\".\"Notice\" SET notice = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, notice);  
            statement.setInt(2, id);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }}