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
    <h2>Update Notice Data</h2>
    <form action="UpdateNoticeSer" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    
        <div class="form-group">
            <label for="notice">Name:</label>
            <input type="text" class="form-control" id="notice" name="notice" placeholder="Enter Notice" required>
        </div>
       
         <button type="submit" class="btn btn-primary">Update</button>
        <a href="index.jsp" class="btn btn-secondary">Cancel</a>
    </form>
</div>
<%} %>
</body>
</html>
