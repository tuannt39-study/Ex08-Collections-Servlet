<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<%
String error = (String) request.getAttribute("error");
if (error == null){
	error = "";
}
if (session.getAttribute("user") != null) {
	response.sendRedirect("/Ex08");
}
%>
	<h2>Login</h2>
	<p><%= error %></p>
	<form action="UserController" method="POST">
		Username: <input type="text" name="userEmail"> <br />
		Password: <input type="text" name="userPass"> <br />
		<input type="hidden" value="login" name="action">
		<input type="submit" value="Login">
	</form>
</body>
</html>