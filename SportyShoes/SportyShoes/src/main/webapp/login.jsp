<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
 
<h2>Login</h2>

<form action="login" method="post">
  <label for="username">UserName:</label><br>
  <input type="text" id="username" name="username"><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password"><br>
  <br>
  <input type="submit" value="Login">
</form> 


</body>
</html>