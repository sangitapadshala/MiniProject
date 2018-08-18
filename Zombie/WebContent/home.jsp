<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
<jsp:include page="banner.jsp"/>
	<h1 style="color: blue; text-align: center; margin-top: 100px;">Welcome</h1>
	<div align="center">
	<a href="login.jsp">Login</a>
	</div>
	<br>
	<div align="center">
		<font color="red" text-align="center">${Prompt}</font>
		
		<a href="register.jsp">Register</a>
</div>
</body>
</html>