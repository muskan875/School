package com.school;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.school.util.ConnectionUtil;

@WebServlet("/FeedbackListSer")
public class FeedbackListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create list to store feedback objects
        List<Feedback> feedbackList = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"User\".\"feedback\"");
             ResultSet rs = stmt.executeQuery()) {

            // Iterate over ResultSet and add feedback objects to list
            while (rs.next()) {
                int id = rs.getInt("id");
                String feedback = rs.getString("feedback");
                String studentName = rs.getString("studentName");
                Feedback fb = new Feedback(id ,studentName, feedback);
                feedbackList.add(fb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Return empty list if an error occurs
            feedbackList = new ArrayList<>();
        }

        // Convert list to JSON using Gson
        Gson gson = new Gson();
        String json = gson.toJson(feedbackList);

        // Set JSON data as a request attribute
        request.setAttribute("jsonData", json);

        // Forward the request to feedback.jsp
        request.getRequestDispatcher("FeedbackJson.jsp").forward(request, response);
        System.out.println("feedbackdatalist--"+request.getAttribute("jsonData"));
    }
}
