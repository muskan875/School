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

@WebServlet("/studentResultServlet")
public class StudentResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the user ID from the request parameter
//        String userId = request.getParameter("id");
    	
    	HttpSession httpsession = request.getSession();
    	
   String email =(String) httpsession.getAttribute("email");

        // Create list to store user data
        String name = null;
        String address =null;
        String dob = null;
        String gender = null;
        double hindi = 0;
        double english = 0;
        double maths = 0;
        double physics = 0;
        double chemistry = 0;
        double total = 0;
        double percentage = 0;
        
        // Database connection
        try (Connection conn = ConnectionUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement("SELECT u.*, m.*"
                		+ "FROM \"User\".\"User\" u join \"User\".\"marksheet\" m on u.email = m.email where u.email=?;")) {
            pstmt.setString(1, email);

            // Execute the query
            try (ResultSet rs = pstmt.executeQuery()) {
                // Check if a user with the given ID exists
                if (rs.next()) {
                    // Retrieve user data from the result set
                    name = rs.getString("name");
                  address = rs.getString("address");
                  dob = rs.getString("dob");
                  gender = rs.getString("gender");
                   hindi = Double.parseDouble(rs.getString("hindi"));
                    english = Double.parseDouble(rs.getString("english"));
                    maths = Double.parseDouble(rs.getString("maths"));
                    physics = Double.parseDouble(rs.getString("physics"));
                    chemistry = Double.parseDouble(rs.getString("chemistry"));
                    total = Double.parseDouble(rs.getString("total"));
                    percentage = Double.parseDouble(rs.getString("percentage"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (name != null && hindi > 0 && english > 0 && maths > 0 && physics  > 0 && chemistry > 0 && total > 0 && percentage>0) {
            // Set the user data as request attributes
            request.setAttribute("name", name);
            request.setAttribute("gender",gender);
            request.setAttribute("dob", dob);
            request.setAttribute("address", address);
            request.setAttribute("email", email);
            request.setAttribute("hindi", hindi);
            request.setAttribute("english", english);
            request.setAttribute("maths", maths);
            request.setAttribute("physics", physics);
            request.setAttribute("chemistry", chemistry);
            request.setAttribute("total", total);
            request.setAttribute("percentage", percentage);
            
            if (percentage > 40) {
                request.setAttribute("result", "Pass");
            } else {
                request.setAttribute("result", "Fail");
            }
            
            // Forward the request to a JSP page for display
            RequestDispatcher dispatcher = request.getRequestDispatcher("StudentResult.jsp");
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
