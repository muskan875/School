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
 * Servlet implementation class UpdateResultServlet
 */
@WebServlet("/UpdateResultSer")
public class UpdateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UpdateResultServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
        String name = request.getParameter("name");
        String hindi = request.getParameter("hindi");
        String english = request.getParameter("english");
        String maths = request.getParameter("maths");
        String physics = request.getParameter("physics");
        String chemistry = request.getParameter("chemistry");

        // Ensure that id and mobile are not null before parsing them
        int userId = id != null && !id.isEmpty() ? Integer.parseInt(id) : 0;
        int hin = hindi != null && !hindi.isEmpty() ? Integer.parseInt(hindi) : 0;
        int eng = english != null && !english.isEmpty() ? Integer.parseInt(english) : 0;
        int math = maths != null && !maths.isEmpty() ? Integer.parseInt(maths) : 0;
        int phys = physics != null && !physics.isEmpty() ? Integer.parseInt(physics) : 0;
        int chem = chemistry != null && !chemistry.isEmpty() ? Integer.parseInt(chemistry) : 0;

        // Retrieve other form fields like address, email, dob, gender, password, etc.

        boolean updateSuccessful = updatemarks(userId, name, hin, eng, math, phys, chem);
        if (updateSuccessful) {
        	response.sendRedirect(request.getContextPath() + "/result?");
        } else {
        	response.sendRedirect(request.getContextPath() + "/result?errorMsg=Failed to update record");
        }
    }

    private boolean updatemarks(int id, String name, int hin, int eng, int math, int phys, int chem) {
        try {
            int totalMarks = hin + eng + math + phys + chem;
            double percentage = totalMarks / 5.0; // Calculate percentage with double precision
            Connection connection = ConnectionUtil.getConnection();
            // Enclose schema and table name in double quotes and use proper casing
            String sql = "UPDATE \"User\".\"marksheet\" SET name = ?, hindi = ?, english = ?, maths = ?, physics = ?, chemistry = ?, total = ?, percentage = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name); 
            statement.setInt(2, hin);
            statement.setInt(3, eng);
            statement.setInt(4, math);
            statement.setInt(5, phys);
            statement.setInt(6, chem);
            statement.setInt(7, totalMarks);
            statement.setDouble(8, percentage);
            statement.setInt(9, id);

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