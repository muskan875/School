<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher Dashboard</title>
<style>
    .navbar {
        position: fixed;
        top: 0;
        width: 100%;
        background-color: #333;
        overflow: hidden;
    }
    .navbar a {
        float: left;
        display: block;
        color: white;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
    }
    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }
    .navbar a.active {
        background-color: #111;
        color: white;
    }
    .navbar-right {
        float: right;
    }
    .sidebar {
        height: 100%;
        width: 200px;
        position: fixed;
        top: 60px;
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
        margin-top: 60px;
        margin-left:300px;
        padding: 16px;
        text-align: left; /* Center align content */
    }
</style>
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
<div class="navbar">
    <a href="#" class="active">StudentManagementSystem</a>

    <div class="navbar-right">
        <a href="Logout.jsp">Logout</a>
    </div>
</div>
<div class="sidebar">
    <a href="#" onclick="loadData('Marksheet')">MarkSheet</a>

   <form action="studentList" method="get">
    <button type="submit" style="border: none; font-size:18px; background: none; color: grey; margin-left:7px;padding:6px; text-decoration: none; cursor: pointer;">StudentList</button>
    </form>
    
      <form action="subjectList" method="get">
    <button type="submit" style="border: none; font-size:18px; background: none; color: grey; margin-left:7px;padding:6px; text-decoration: none; cursor: pointer;">Subject List</button>
    </form>
    
    <a href="#" onclick="loadData('AddFeedback')">AddFeedback</a>
   <!--  <a href="#" onclick="loadFeedbackList()">Feedback List</a> -->
     
     <form action="FeedbackListSer" method="get">
    <button type="submit" style="border: none; font-size:18px; background: none; color: grey; margin-left:7px;padding:6px; text-decoration: none; cursor: pointer;">Feedback List</button>
    </form>
    
     <form action="result" method="get">
    <button type="submit" style="border: none; font-size:18px; background: none; color: grey; margin-left:7px;padding:6px; text-decoration: none; cursor: pointer;">Result</button>
    </form>
    
    <form action="noticeServlet" method="get">
    <button type="submit" style="border: none; font-size:18px; background: none; color: grey; margin-left:7px;padding:6px; text-decoration: none; cursor: pointer;">Notice List</button>
    </form>
</div>
<div class="content" id="content">
 <h1 style="margin-top:100px; text-align: center;">
 Hey <%= session.getAttribute("name") %>,<br> Welcome To Teacher Dashboard Of School Management System</h1> 
  </div> 
  
<%} %>

} %>
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
    
    function loadResultList() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("content").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "result", true); // Calling the servlet responsible for student list
        xhttp.send();
    }
    function loadFeedbackData(event) {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                // Handle the response here if needed
            }
        };
        xhttp.open("GET", "FeedbackListSer", true);
        xhttp.send();
    }

    function loadFeedback() {
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("content").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "AddFeedback", true); // Calling the servlet responsible for student list
        xhttp.send();
    }
    
    
    function loadFeedbackList() {
       var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("content").innerHTML = this.responseText;
            }
        };
        xhttp.open("GET", "FeedbackListSer", true); // Calling the servlet responsible for student list
        xhttp.send();
    }
</script>
</body>
</html>
