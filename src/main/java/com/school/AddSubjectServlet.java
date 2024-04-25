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

		@WebServlet("/AddSubject")
		public class AddSubjectServlet extends HttpServlet {
		    private static final long serialVersionUID = 1L;

		    protected void doPost(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
		        String name = request.getParameter("name");
		        String code = request.getParameter("code");

		        try {
		            Connection connection = ConnectionUtil.getConnection();
		            PreparedStatement preparedStatement = connection.prepareStatement(
		                    "INSERT INTO \"User\".\"subjects\" (name, code) VALUES (?, ?)");
		            preparedStatement.setString(1, name);
		            preparedStatement.setString(2, code);
		            preparedStatement.executeUpdate();
		            connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        response.sendRedirect("AddSubject.jsp");
		    }
		

	}


