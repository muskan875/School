<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.school.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher List</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom CSS */
        body {
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        button {
            padding: 5px 10px;
            margin-right: 5px;
            border: none;
            cursor: pointer;
        }
        .btn-primary {
            background-color: #007bff;
            color: white;
        }
        .btn-danger {
            background-color: #dc3545;
            color: white;
        }
    </style>
</head>
<body>
<h2>Student List</h2>
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Mobile</th>
                <th>Address</th>
                <th>Gender</th>
                <th>dob</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.mobile}</td>
                    <td>${student.address}</td>
                    <td>${student.gender}</td>
                    <td>${student.dob}</td>
                    <td>
                        <button class="btn btn-primary" onclick="updateStudent(${student.id})">Update</button>
                        <button class="btn btn-danger" onclick="deleteStudent(${student.id})">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <!-- Bootstrap JS (Optional, if needed for functionality) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <script>
    $(document).ready(function() {
        $.ajax({
            url: "StudentListServlet",
            type: "GET",
            dataType: "json",
            success: function(response) {
                if (response.length > 0) {
                    var studentTable = $("#studentTable").find("tbody");
                    $.each(response, function(index, student) {
                        var row = "<tr>" +
                            "<td>" + student.name + "</td>" +
                            "<td>" + student.email + "</td>" +
                            "<td>" + student.mobile + "</td>" +
                            "<td>" + student.address + "</td>" +
                            "<td>" + student.gender + "</td>" +
                            "<td>" + student.dob + "</td>" +
                            "</tr>";
                        studentTable.append(row);
                    });
                } else {
                    $("#studentTable").after("<p>No students found.</p>");
                }
            },
            error: function(xhr, status, error) {
                console.error("Error fetching student list: " + error);
                $("#studentTable").after("<p>Error fetching student list.</p>");
            }
        });
    });
</body>
</html>