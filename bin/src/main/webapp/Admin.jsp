<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
    <style>
        .sidebar {
            height: 100%;
            width: 200px;
            position: fixed;
            top: 0;
            left: 0;
            background-color: #111;
            padding-top: 20px;
        }
        .sidebar a {
            padding: 10px 15px;
            text-decoration: none;
            font-size: 20px;
            color: #818181;
            display: block;
        }
        .sidebar a:hover {
            color: #f1f1f1;
        }
        .content {
            margin-left: 220px;
            padding: 16px;
            height: 1000px; /* Should be adjusted based on content */
        }
    </style>
</head>
<body>
<div class="sidebar">
         <a href="#" onclick="loadData('Index')">Registration</a>
        <a href="#" onclick="loadData('TeacherList')">Teacher List</a>
        <a href="#" onclick="loadData('StudentList')">Student List</a>
        <a href="#" onclick="loadData('Subject')">Subject List</a>
        <a href="#" onclick="loadData('Notice')">Notice</a>
    </div>

    <div class="content" id="content">
        <h1>Welcome, Admin!</h1>
    </div>

    <script>
    function loadData(page) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("content").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", page + ".jsp", true);
        xhttp.send();
    }

    </script>
</body>
</html>