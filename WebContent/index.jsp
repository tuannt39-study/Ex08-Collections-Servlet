<%@page import="vn.its.ex07.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
 	<%
		User user = null;
		if (session.getAttribute("user") != null) {
			user = (User) session.getAttribute("user");
			if (user != null) {
	%>
	<a><c:out value="${user.userEmail}" /></a><br />
	<a href="/Ex08/UserController?action=logout">Logout</a> <br />
	<%
			}
		} else {
	%>
	<a href="/Ex08/UserController?action=login">Login</a> <br />
	<%
		}
	%>
	<a href="/Ex08/BaiVietController?action=baiVietList">Quan Ly Bai Viet</a> <br />
	<a href="/Ex08/OtoController?action=otoList">Quan Ly Oto</a>
</body>
</html>