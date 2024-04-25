<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Information</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles can be added here */
        body {
            padding: 20px;
        }
    </style>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires", "0"); 

if(session.getAttribute("name")==null){
    response.sendRedirect("Login.jsp");
}
else{
%>
    <div class="container">
        <h2>User Information</h2>
        <div class="card">
            <div class="card-body">
                <p class="card-text"><strong>Name:</strong> <%= request.getAttribute("name") %></p>
                <p class="card-text"><strong>Email:</strong> <%= request.getAttribute("email") %></p>
                <p class="card-text"><strong>Address:</strong> <%= request.getAttribute("address") %></p>
                <p class="card-text"><strong>MobileNo:</strong> <%= request.getAttribute("mobileno") %></p>
                <p class="card-text"><strong>Gender:</strong> <%= request.getAttribute("gender") %></p>
                <p class="card-text"><strong>Date of Birth:</strong> <%= request.getAttribute("dob") %></p>
            </div>
        </div>
    </div>
<% } %> 

<!-- Bootstrap JS (optional, if you need JavaScript features from Bootstrap) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
