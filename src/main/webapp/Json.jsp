<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registered</title>
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
 <h2 class="mt-4">User Registered</h2>
    <div id="tableContainer" class="table-responsive"></div>
<button type="button" class="btn btn-primary mt-3" onclick="redirectToLogin()">Login</button>
<%} %>
    <script>
        // Assuming jsonData is the JSON data received from the servlet
        var jsonData = '<%= request.getAttribute("jsonData") %>'; // Assuming you set jsonData as a request attribute in your servlet

        // Parse the JSON string into a JavaScript object
        var data = JSON.parse(jsonData);

        // Create HTML table dynamically
        var tableContainer = document.getElementById("tableContainer");
        var tableHtml = "<table class='table table-bordered table-striped'><thead><tr>";

        // Add table headers using object keys
        for (var key in data) {
            tableHtml += "<th>" + key + "</th>";
        }
        tableHtml += "</tr></thead><tbody><tr>";

        // Add table data using object values
        for (var key in data) {
            tableHtml += "<td>" + data[key] + "</td>";
        }
        tableHtml += "</tr></tbody></table>";
    
        // Append table to the container
        tableContainer.innerHTML = tableHtml;
        function redirectToLogin() {
            window.location.href = "Login.jsp"; // Replace 'login.jsp' with the actual login page URL
        }
      
    </script>
</body>
</html>