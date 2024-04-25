package com.school;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.school.dto.UserDto;
import com.school.exception.UserNotFoundException;
import com.school.service.UserService;
import com.school.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegisterServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    UserService userService = new UserServiceImpl();
		    PrintWriter out = response.getWriter();
		   
		    String name = request.getParameter("name");
		    String email = request.getParameter("email");
		    String mobile = request.getParameter("mobileno");
		    long mobileNo = Long.parseLong(mobile);
		    String gender = request.getParameter("gender");
		    String address = request.getParameter("address");
		    String dob = request.getParameter("dob");
		    String userrole = request.getParameter("userrole");
		    String password = request.getParameter("password");

		    UserDto userDto = new UserDto();
		    userDto.setName(name);
		    userDto.setEmail(email);
		    userDto.setMobileno(mobileNo);
		    userDto.setGender(gender);
		    userDto.setAddress(address);
		    userDto.setDob(dob);
		    userDto.setRole(userrole);
		    userDto.setPassword(password);

		    try {
		    	
		    	 if (userService.isEmailExists(email)) {
		    	        // Email already registered
		    	        response.setContentType("text/html");
		    	        out.println("<h3>Error: This email address is already registered. Please use another email address.</h3>");
		    	        return; // Stop further execution
		    	    }
		        UserDto savedUserDto = userService.registration(userDto);
		        if (savedUserDto.getId() > 0) {
	                // Success: User registered successfully
	                Gson gson = new Gson();
	                String json = gson.toJson(savedUserDto);

	                // Set JSON data as request attribute
	                request.setAttribute("jsonData", json);

	                // Forward the request to the JSP page
	                RequestDispatcher dispatcher = request.getRequestDispatcher("Json.jsp");
	                dispatcher.forward(request, response);
		        } else {
		            // Error: Registration failed
		            response.setContentType("text/html");
		            out.println("<h3>Error: User registration failed!</h3>");
		        }
		    } catch (UserNotFoundException e) {
		        // Exception handling: User not found
		        response.setContentType("text/html");
		        out.println("<h3>Error: " + e.getMessage() + "</h3>");
		    }
		}

		} 
	


