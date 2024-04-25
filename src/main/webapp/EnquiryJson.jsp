<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ include file="Admin.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enquiry Data</title>
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
        <h2>Enquiry Data</h2>
        <div id="tableContainer" class="table-responsive"></div>
    </div>
<%} %>
    <script>
        // Assuming jsonData is the JSON data received from the servlet
        var jsonData = '<%= request.getAttribute("jsonData") %>'; // Assuming you set jsonData as a request attribute in your servlet
        
        // Parse the JSON string into a JavaScript array of objects
        var data = JSON.parse(jsonData);
         console.log("jssoonnn data");
        // Create HTML table dynamically
        var tableContainer = document.getElementById("tableContainer");
        var tableHtml = "<table class='table table-bordered table-striped'><thead><tr>";

        // Add table headers using keys from the first object
        for (var key in data[0]) {
            tableHtml += "<th>" + key + "</th>";
        }
        <% if(session.getAttribute("userRole").equals("admin")){%>
        tableHtml += "<th>Actions</th></tr></thead><tbody>";
        <%}%>
        // Add table data using values from each object
        data.forEach(function(item) {
            tableHtml += "<tr>";
            for (var key in item) {
                tableHtml += "<td>" + item[key] + "</td>";
            }
            <% if(session.getAttribute("userRole").equals("admin")){%>
            tableHtml += "<td><button onclick='updateRecord(\"" + item.id + "\")'>Update</button>"
                         + "<button onclick='deleteRecord(\"" + item.id + "\")'>Delete</button></td>";
            tableHtml += "</tr>";
            <%}%>
        });

        tableHtml += "</tbody></table>";

        // Append table to the container
        tableContainer.innerHTML = tableHtml;
console.log(tableHtml);

        // Function to handle update button click
        function updateRecord(id)
 {
            // Implement the update logic, e.g., redirect to an update servlet with the record id
            window.location.href = "UpdateEnquiry.jsp?id=" + id;
        }

        // Function to handle delete button click
        function deleteRecord(id)
 {
            // Implement the delete logic, e.g., redirect to a delete servlet with the record id
            window.location.href = "DeleteServlet?id=" + id;
        }
    </script>
</body>
</html>