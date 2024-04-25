<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Results</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
        request.getRequestDispatcher("/result").include(request, response);
} %>
</body>
</html>