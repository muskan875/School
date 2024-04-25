<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html> <html> <head> <meta charset="UTF-8"> <title>Login</title> <style> body { font-family: Arial, sans-serif; }
form { margin: 0 auto; width: 300px; padding: 20px; border: 1px solid #ccc; border-radius: 5px; box-shadow: 0px 0px 10px rgba(0,0,0,0.1); }

h2 { text-align: center; margin-bottom: 20px; }

label { display: block; margin-bottom: 5px; }

input[type="text"], input[type="password"] { width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; }

select { width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; box-sizing: border-box; }

input[type="submit"] { width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; cursor: pointer; }

input[type="submit"]:hover { background-color: #45a049; } </style>

</head> <body> <form action="LoginServlet" method="post"> <h2>Login</h2> <label for="username">Username:</label> <input type="text" id="name" name="name" required><br><br> <label for="password">Password:</label> <input type="password" id="password" name="password" required><br><br> <label for="role">Role:</label> <select id="role" name="role"> <option value="admin">Admin</option> <option value="teacher">Teacher</option> <option value="student">Student</option> </select><br><br> <input type="submit" value="Login"> </form> </body> </html>