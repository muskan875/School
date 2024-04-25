package com.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.school.exception.UserNotFoundException;
import com.school.util.ConnectionUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 PrintWriter out = response.getWriter();
    	 
    	String name = request.getParameter("name");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        
        UserCreds userRole = authenticateUser(name, password, role);

        if (userRole.getRole() != null) {
            HttpSession session = request.getSession(); // Get the session object
            
            session.setAttribute("id", userRole.getId());
            session.setAttribute("name", name); // Set session attribute for user's name
            session.setAttribute("userRole", userRole.getRole()); // Set session attribute for user's role
            session.setAttribute("email", userRole.getEmail());

            if ((userRole.getRole()).equals("admin")) {
            	
                response.sendRedirect("Admin.jsp");
            } else if ((userRole.getRole()).equals("teacher")) {
                response.sendRedirect("Teacher.jsp");
            } else if ((userRole.getRole()).equals("student")) {
                response.sendRedirect("Student.jsp");
            }
        } else {
            // User not found or incorrect username/password
            request.setAttribute("errorMessage", "User not found or incorrect username/password.");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    private UserCreds authenticateUser(String name, String password, String role) {
    	UserCreds userCreds = new UserCreds();
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM \"User\".\"User\" WHERE name=? AND password=? AND userrole=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, role);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	
            	String r = rs.getString("userrole");
            	int val = Integer.parseInt(rs.getString("id"));
            	String mail = rs.getString("email");
            	userCreds.setEmail(mail);
            	userCreds.setId(val);
                userCreds.setRole(r);
                return userCreds;
            }  else {
            	throw new UserNotFoundException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
        return null;
    }
}
