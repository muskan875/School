<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.school.User" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>
<%
response. setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTI 
response. setHeader("Pragma","no-cache");
response. setHeader("Expires", "0"); 
if(session.getAttribute("name")==null){
	response.sendRedirect("Login.jsp");
}
else{

        // Forward the request to the servlet
        request.getRequestDispatcher("/studentList").include(request, response);
}   %>

</body>
</html>