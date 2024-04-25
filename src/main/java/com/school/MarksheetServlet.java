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

import com.google.gson.Gson;
import com.school.util.ConnectionUtil;

@WebServlet("/submitMark")
public class MarksheetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MarksheetServlet() {
        super();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        Double hindi = Double.parseDouble(req.getParameter("hindi"));
        Double english = Double.parseDouble(req.getParameter("english"));
        Double maths = Double.parseDouble(req.getParameter("maths"));
        Double physics = Double.parseDouble(req.getParameter("physics"));
        Double chemistry = Double.parseDouble(req.getParameter("chemistry"));

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
     
        
        try {
            con = ConnectionUtil.getConnection();

            if (con != null) {
                // Check if the email exists in the database
                ps = con.prepareStatement("SELECT * FROM \"User\".\"User\" WHERE email = ?");
                ps.setString(1, email);
                rs = ps.executeQuery();

                if (rs.next()) {
                    // Email exists, proceed with inserting marksheet data
                    ps = con.prepareStatement("INSERT INTO \"User\".\"marksheet\"(name, email, hindi, english, maths, physics, chemistry, total, percentage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    ps.setString(1, name);
                    ps.setString(2, email);
                    ps.setDouble(3, hindi);
                    ps.setDouble(4, english);
                    ps.setDouble(5, maths);
                    ps.setDouble(6, physics);
                    ps.setDouble(7, chemistry);
                    
                    double total = hindi + english + maths + physics + chemistry;
                    ps.setDouble(8, total);
                    
                    int totalSubjects = 5; // Assuming 5 subjects
                    double maximumMarksPerSubject = 100; // Assuming maximum marks for each subject
                    double percentage = (total / (totalSubjects * maximumMarksPerSubject)) * 100;
                    ps.setDouble(9, percentage);

                    int count = ps.executeUpdate();

                    if (count == 1) {
                        // Data successfully inserted
                        out.println(gson.toJson("Data successfully inserted"));
                    } else {
                        // Insertion failed
                        out.println(gson.toJson("Insertion failed"));
                    }
                } else {
                    // Email does not exist in the database
                    out.println(gson.toJson("Email not registered"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println(gson.toJson("Error: " + e.getMessage()));
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
