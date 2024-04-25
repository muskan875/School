<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
%>
  <h2>Add Subject</h2>
    <form action="AddSubject" method="post">
        <label for="subjectName">Subject Name:</label>
        <input type="text" id="name" name="name"><br><br>
        
        <label for="subjectCode">Subject Code:</label>
        <input type="text" id="code" name="code"><br><br>
        
        <input type="submit" value="Submit">
    </form>
     <%
}
    %>
</body>
</html>