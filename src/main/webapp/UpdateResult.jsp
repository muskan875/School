<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User Data</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTI 
response.setHeader("Pragma","no-cache");
response.setHeader("Expires", "0"); 

if(session.getAttribute("name")==null){
    response.sendRedirect("Login.jsp");
}
else{
%>
<div class="container mt-5">
    <h2>Update User Data</h2>
    <form action="UpdateResultSer" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" required>
        </div>
       
        <div class="form-group">
            <label for="hindi">Hindi:</label>
            <input type="number" class="form-control" id="hindi" name="hindi" placeholder="Enter marks" required>
        </div>
        <div class="form-group">
            <label for="english">English:</label>
            <input type="number" class="form-control" id="english" name="english" placeholder="Enter marks" required>
        </div>
        <div class="form-group">
            <label for="maths">English:</label>
            <input type="number" class="form-control" id="maths" name="maths" placeholder="Enter marks" required>
        </div>
        <div class="form-group">
            <label for="physics">Physics:</label>
            <input type="number" class="form-control" id="physics" name="physics" placeholder="Enter marks" required>
        </div>
        
        <div class="form-group">
            <label for="chemistry">Chemistry:</label>
            <input type="number" class="form-control" id="chemistry" name="chemistry" placeholder="Enter marks" required>
        </div>
        
      
        <button type="submit" class="btn btn-primary">Update</button>
        <a href="index.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>
<%} %>
</body>
</html>
