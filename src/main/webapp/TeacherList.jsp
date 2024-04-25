<%@ page contentType="text/html;charset=UTF-8" language="java" %>	
<%@ page import="com.school.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<!DOCTYPE html>
<html>
<head>
   <title>Teacher List</title>
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
        request.getRequestDispatcher("/teacherList").include(request, response);
}  %>
    
    


</body>
</html>
