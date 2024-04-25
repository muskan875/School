package com.school;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.util.ConnectionUtil;

@WebServlet("/UpdateUserSer")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        
        // Ensure that id and mobile are not null before parsing them
        int userId = id != null && !id.isEmpty() ? Integer.parseInt(id) : 0;
        long mobileNo = mobile != null && !mobile.isEmpty() ? Long.parseLong(mobile) : 0;

        // Retrieve other form fields like address, email, dob, gender, password, etc.

        String userRole = updateUser(userId, name, address, email, mobileNo, dob, gender, password);
        if (userRole != null && userRole.equalsIgnoreCase("student")) {
            response.sendRedirect(request.getContextPath() + "/studentList");
        } else if (userRole != null && userRole.equalsIgnoreCase("teacher")) {
            response.sendRedirect(request.getContextPath() + "/teacherList");
        } else {
            response.sendRedirect(request.getContextPath() + "?errorMsg=Failed to update record");
        }
    }
    

    private String updateUser(int id, String name, String address, String email, long mobile, String dob, String gender, String password) {
        try {
            Connection connection = ConnectionUtil.getConnection();
            // Enclose schema and table name in double quotes and use proper casing
            String sql = "UPDATE \"User\".\"User\" SET name = ?, address = ?, email = ?, mobileno = ?, dob = ?, gender = ?, password = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, email);
            statement.setLong(4, mobile);
            statement.setString(5, dob);
            statement.setString(6, gender);
            statement.setString(7, password);
            statement.setInt(8, id);

            int rowsAffected = statement.executeUpdate();
            
            // After update, fetch user's role
            String userRole = null;
            if (rowsAffected > 0) {
                // Fetch user role from the database
                String getUserRoleSql = "SELECT userrole FROM \"User\".\"User\" WHERE id = ?";
                PreparedStatement getUserRoleStatement = connection.prepareStatement(getUserRoleSql);
                getUserRoleStatement.setInt(1, id);
                ResultSet rs = getUserRoleStatement.executeQuery();
                if (rs.next()) {
                    userRole = rs.getString("userrole");
                }
                getUserRoleStatement.close();
            }

            statement.close();
            connection.close();

            return userRole;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
