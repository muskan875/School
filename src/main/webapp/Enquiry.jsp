<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enquiry Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
    <div class="container mt-5">
        <h2 class="mb-4">Enquiry Form</h2>
        <form action="EnquirySer" method="post">
        
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="mobileno">Mobile No:</label>
                <input type="text" class="form-control" id="mobileno" name="mobileno" required>
            </div>
           <div class="form-group">
    <label for="role">Role:</label><br>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" id="role_student" name="role" value="student" required>
        <label class="form-check-label" for="role_student">Student</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" id="role_teacher" name="role" value="teacher">
        <label class="form-check-label" for="role_teacher">Teacher</label>
    </div>
</div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
    
    <%} %>
</body>
</html>
