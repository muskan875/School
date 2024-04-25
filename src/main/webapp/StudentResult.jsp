<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Information</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">   
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setHeader("Expires", "0"); // Proxies

    if(session.getAttribute("name") == null) {
        response.sendRedirect("Login.jsp");
    } else {
%>
<div class="container mt-5">
    <h2 class="text-center mb-4">Student MarkSheet</h2>
    
 <div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="table-responsive" style="max-width: 600px; max-height: 200px; overflow: auto;">
                <table class="table table-bordered table-sm" style="width: 100%;">
                    <tbody>
                        <tr>
                            <td class="text-center font-weight-bold" style="width: 40%;">Name</td>
                            <td class="text-center" style="width: 60%;"><%= request.getAttribute("name") %></td>
                        </tr>
                        <tr>
                            <td class="text-center font-weight-bold">Email</td>
                            <td class="text-center"><%= request.getAttribute("email") %></td>
                        </tr>
                        <tr>
                            <td class="text-center font-weight-bold">Address</td>
                            <td class="text-center"><%= request.getAttribute("address") %></td>
                        </tr>
                        <tr>
                            <td class="text-center font-weight-bold">Gender</td>
                            <td class="text-center"><%= request.getAttribute("gender") %></td>
                        </tr>
                        <tr>
                            <td class="text-center font-weight-bold">Date of Birth</td>
                            <td class="text-center"><%= request.getAttribute("dob") %></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
 
    <div class="table-responsive">
    
        <table class="table table-bordered">
            <thead class="thead-dark">
               
                <tr>
                    <th scope="col" class="text-center">Subject</th>
                    <th scope="col" class="text-center">Marks Obtained</th>
                    <th scope="col" class="text-center">Total Marks</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row" class="text-center">Hindi</th>
                    <td class="text-center"><%= request.getAttribute("hindi") %></td>
                    <td class="text-center">100</td>
                </tr>
                <tr>
                    <th scope="row" class="text-center">English</th>
                    <td class="text-center"><%= request.getAttribute("english") %></td>
                    <td class="text-center">100</td>
                </tr>
                <tr>
                    <th scope="row" class="text-center">Maths</th>
                    <td class="text-center"><%= request.getAttribute("maths") %></td>
                    <td class="text-center">100</td>
                </tr>
                <tr>
                    <th scope="row" class="text-center">Physics</th>
                    <td class="text-center"><%= request.getAttribute("physics") %></td>
                    <td class="text-center">100</td>
                </tr>
                <tr>
                    <th scope="row" class="text-center">Chemistry</th>
                    <td class="text-center"><%= request.getAttribute("chemistry") %></td>
                    <td class="text-center">100</td>
                </tr>
                <tr>
                    <th scope="row" class="text-center">Total</th>
                    <td class="text-center"><%= request.getAttribute("total") %></td>
                    <td class="text-center">500</td>
                </tr>
                <tr>
                    <th scope="row" class="text-center">Percentage</th>
                    <td class="text-center" colspan="2"><%= request.getAttribute("percentage") %></td>
                </tr>
                <tr>
                    <th scope="row" class="text-center">Result</th>
                    <td class="text-center" colspan="2"><%= request.getAttribute("result") %></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
<% } %>
<!-- Bootstrap JS (optional, if you need JavaScript features from Bootstrap) -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
