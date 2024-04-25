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

import com.school.util.ConnectionUtil;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       

    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   List<String> noticeList = getNoticeListFromDatabase();

           request.setAttribute("noticeList", noticeList);
           request.getRequestDispatcher("Notice.jsp").forward(request, response);
       }

       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String notice = request.getParameter("notice");

           try {
        	   Connection conn = ConnectionUtil.getConnection();
               PreparedStatement ps = conn.prepareStatement("INSERT INTO \"User\".\"Notice\" (notice) VALUES (?)");
               ps.setString(1, notice);
               ps.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           }

           // Redirect to the referring page
           response.sendRedirect(request.getHeader("Referer"));
       }

       private List<String> getNoticeListFromDatabase() {
           List<String> noticeList = new ArrayList<>();
           Connection connection = null;
           PreparedStatement ps = null;
           ResultSet rs = null;

           try {
               connection = ConnectionUtil.getConnection();
               ps = connection.prepareStatement("SELECT notice FROM \"User\".\"Notice\"");
               rs = ps.executeQuery();

               while (rs.next()) {
                   noticeList.add(rs.getString("notice"));
                  
               }
           } catch (SQLException e) {
               e.printStackTrace();
           } finally {
               try {
                   if (rs != null) rs.close();
                   if (ps != null) ps.close();
                   if (connection != null) connection.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }

           return noticeList;
       }
   }