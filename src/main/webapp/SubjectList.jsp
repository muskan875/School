<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Subject List</title>
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
        request.getRequestDispatcher("/subjectList").include(request, response);
}   %>
</body>
</html>
