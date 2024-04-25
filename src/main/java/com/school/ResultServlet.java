//package com.school;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.school.util.ConnectionUtil;
//
///**
// * Servlet implementation class ResultServlet
// */
//@WebServlet("/result")
//public class ResultServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ResultServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//    	 List<Marksheet> resultList = getResultFromDatabase();
//
//	        // Convert the list to JSON using Gson
//	        Gson gson = new Gson();
//	        String json = gson.toJson(resultList);
//
//	        // Set response content type to JSON
//	        response.setContentType("application/json");
//	        response.setCharacterEncoding("UTF-8");
//
//	        // Send JSON data as response
////	        PrintWriter out = response.getWriter();
////	        out.print(json);
////	        out.flush();
//	        RequestDispatcher dispatcher = request.getRequestDispatcher("ResultJson.jsp");
//            dispatcher.forward(request, response);
//	    }
//
//	    private List<Marksheet> getResultFromDatabase() {
//	        List<Marksheet> resultList = new ArrayList<>();
//	        Connection conn = null;
//	        PreparedStatement stmt = null;
//	        ResultSet rs = null;
//
//	        try {
//	            // Establish database connection
//	            ConnectionUtil connectionUtil = new ConnectionUtil();
//	            conn = connectionUtil.getConnection();
//
//	            // Query to fetch teachers
//	            String sql = "SELECT * FROM \"User\".\"marksheet\"";
//	            stmt = conn.prepareStatement(sql);
//	            rs = stmt.executeQuery();
//
//	            // Fetch data and add teachers to the list
//	            while (rs.next()) {
//	            	int  id = rs.getInt("id");
//	                String name = rs.getString("name");
//	               int hindi = rs.getInt("hindi");
//	               int english = rs.getInt("english");
//	               int maths = rs.getInt("maths");
//	               int physics = rs.getInt("physics");
//	               int chemistry = rs.getInt("chemistry");
//	               int total = rs.getInt("total");
//	               int percentage = rs.getInt("percentage");
//	                Marksheet result = new Marksheet(id,name, hindi,english,maths,physics,chemistry,total,percentage);
//	                resultList.add(result);
//	               
//	            }
//
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        } finally {
//	            // Close resources
//	            try {
//	                if (rs != null)
//	                    rs.close();
//	                if (stmt != null)
//	                    stmt.close();
//	                if (conn != null)
//	                    conn.close();
//	            } catch (SQLException e) {
//	                e.printStackTrace();
//	            }
//	        }
//
//	        return resultList;
//	    }
//	}

package com.school;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.school.util.ConnectionUtil;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ResultServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 List<Marksheet> marksheetList = new ArrayList<>();

         try (Connection conn = ConnectionUtil.getConnection();
              PreparedStatement stmt = conn.prepareStatement("SELECT * FROM \"User\".\"marksheet\"");
              ResultSet rs = stmt.executeQuery()) {

             // Iterate over ResultSet and add feedback objects to list
             while (rs.next()) {
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 String email = rs.getString("email");
                 int hindi = rs.getInt("hindi");
                int english= rs.getInt("english");
                 int maths = rs.getInt("maths");
                 int physics = rs.getInt("physics");
                 int chemistry = rs.getInt("chemistry");
                 int total = rs.getInt("total");
                int percentage = rs.getInt("percentage");
                 Marksheet fb = new Marksheet(id, name,email,hindi,english,maths,physics,chemistry,total,percentage);
                 marksheetList.add(fb);
             }
         } catch (SQLException e) {
             e.printStackTrace();
             // Return empty list if an error occurs
             marksheetList = new ArrayList<>();
         }

         // Convert list to JSON using Gson
         Gson gson = new Gson();
         String json = gson.toJson(marksheetList);

         // Set JSON data as a request attribute
         request.setAttribute("jsonData", json);

         // Forward the request to feedback.jsp
         request.getRequestDispatcher("ResultJson.jsp").forward(request, response);
         System.out.println("resultlist--"+request.getAttribute("jsonData"));
     }
 }
