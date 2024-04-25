package com.school;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/noticeServlet")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public NoticeListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Notice> noticeList = new ArrayList<>();

         try (Connection conn = ConnectionUtil.getConnection();
              PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"User\".\"Notice\"");
              ResultSet rs = stmt.executeQuery()) {

             // Iterate over ResultSet and add feedback objects to list
             while (rs.next()) {
                 int id = rs.getInt("id");
                 String notice = rs.getString("notice");
                
                 Notice fb = new Notice(id, notice);
                 noticeList.add(fb);
             }
         } catch (SQLException e) {
             e.printStackTrace();
             // Return empty list if an error occurs
            noticeList = new ArrayList<>();
         }

         // Convert list to JSON using Gson
         Gson gson = new Gson();
         String json = gson.toJson(noticeList);

         // Set JSON data as a request attribute
         request.setAttribute("jsonData", json);

         // Forward the request to feedback.jsp
         request.getRequestDispatcher("NoticeJson.jsp").forward(request, response);
      
     }
 }
