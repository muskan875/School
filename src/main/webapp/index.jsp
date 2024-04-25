<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<style>
body {
	font-family: Arial, sans-serif;
}
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
}
#userForm {
	margin: 0 auto;
	width: 100%;
	padding: 20px;
	border: 1px solid #ccc;
	box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.2);
}

label {
	display: block;
	margin-top: 20px;
}

input[type="text"], input[type="email"], input[type="date"], textarea {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

select {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

input[type="password"] {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

#login{
background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	margin-top: 20px;
	border: none;
	cursor: pointer;
}

button[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	margin-top: 20px;
	border: none;
	cursor: pointer;
}

@media (min-width: 600px) {
	form {
		max-width: 400px;
	}
}

@media (min-width: 900px) {
	form {
		max-width: 600px;
	}
}
</style>

</head>

 <%
response. setHeader("Cache-Control", "no-cache, no-store, must-revalidate");// HTTI 
response. setHeader("Pragma","no-cache");
response. setHeader("Expires", "0"); 

if(session.getAttribute("name")==null){
	response.sendRedirect("Login.jsp");
}
else{
%> 
<body class="container">
	<h2>User Registration</h2>
	<form action="RegisterServlet" method="post" id="userForm" onsubmit="return validateForm()">

		<label for="name">Name:</label> <input type="text" id="name"
			name="name" required> <br> <br> <label for="email">Email:</label>
		<input type="email" id="email" name="email" required> <br>
		<br> <label for="mobile">Mobile Number:</label> <input
			type="text" id="mobileno" name="mobileno" required> <br> <br>

		<label for="gender">Gender:</label> <select id="gender" name="gender">

			<option value="male">Male</option>
			<option value="female">Female</option>
			<option value="other">Other</option>
		</select> <br> <br> <label for="address">Address:</label>

		<textarea id="address" name="address" required></textarea>
		<br> <br> <label for="dob">Date of Birth:</label> <input
			type="date" id="dob" name="dob" required> <br> <br>

		<label for="userrole">Role:</label> <select id="userrole"
			name="userrole">

			<option value="admin">Admin</option>
			<option value="teacher">Teacher</option>
			<option value="student">Student</option>
		</select> <br> <br> <label for="password">Password:</label> <input
			type="password" id="password" name="password" required> <br>
		<br>

		<button type="submit">Register</button>
		<a href="Login.jsp"  id="login"  style="text-decoration: none;" >Login</a>

	</form>
	
 	<%} %> 


<script>
function validateForm() {
    var email = document.getElementById("email").value;
    var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    
    if (!regex.test(email)) {
        alert("Please enter a valid email address.");
        return false;
    }
    
    return true;
}
</script>
</body>
</html>
