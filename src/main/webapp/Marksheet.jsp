<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Student Marksheet</title>
  <style>
        /* Define your CSS rules here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        h2 {
            color:maroon;
             margin: 0 auto;
        }

        #marksheetForm{
            width: 35%;
            margin: 0 auto;
            background-color:silver;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
       
        
    </style>
</head>
<body>

 <h3 >Student Marksheet</h3>
    <form  action="submitMark" method="Post" id="marksheetForm">
          
        <label for="name">Student Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="email">Student Email:</label>
        <input type="text" id="email" name="email" required><br><br>
        
        <label for="hindi">Hindi:</label>
        <input type="number" id="hindi" name="hindi" min="0" max="100" required><br><br>
        
        <label for="english">English:</label>
        <input type="number" id="english" name="english" min="0" max="100" required><br><br>
        
        <label for="maths">Maths:</label>
        <input type="number" id="maths" name="maths" min="0" max="100" required><br><br>
        
        <label for="physics">Physics:</label>
        <input type="number" id="physics" name="physics" min="0" max="100" required><br><br>
        
        <label for="chemistry">Chemistry:</label>
        <input type="number" id="chemistry" name="chemistry" min="0" max="100" required><br><br>
        
        <input type="submit" value="Submit" id="marksubmit">
    </form>
    
    <%
    
    response. setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTI 
    response. setHeader("Pragma","no-cache");
    response. setHeader("Expires", "0"); 
    
    if(session.getAttribute("name")==null){
    	response.sendRedirect("Login.jsp");
    }
    else{
        // Forward the request to the servlet
        request.getRequestDispatcher("/submit").include(request, response);
    }  %>
</body>
</html>