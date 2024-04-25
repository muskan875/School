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
 * Servlet implementation class UpdateSubjectServlet
 */
@WebServlet("/UpdateSubjectSer")
public class UpdateSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSubjectServlet() {
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
        String code = request.getParameter("code");
       
        
        // Ensure that id and mobile are not null before parsing them
        int userId = id != null && !id.isEmpty() ? Integer.parseInt(id) : 0;
        int codeValue = code != null && !code.isEmpty() ? Integer.parseInt(code) : 0;

       

        boolean updateSuccessful = updateSubject(userId, name, code);
        if (updateSuccessful) {
        	response.sendRedirect(request.getContextPath() + "/subjectList?");
        } else {
        	response.sendRedirect(request.getContextPath() + "/subjectList?errorMsg=Failed to update record");
        }
    }

    private boolean updateSubject(int id, String name, String code) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            // Enclose schema and table name in double quotes and use proper casing
            String sql = "UPDATE \"User\".\"subjects\" SET name = ?, code = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, code);
            statement.setInt(3, id);

            int rowsAffected = statement.executeUpdate();

            statement.close();
            connection.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }}