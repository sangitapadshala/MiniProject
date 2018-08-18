<%@page import="lti.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="thistle" text="indigo">
	<h1 ALIGN="center">Zombie-Community of Experts</h1>
	<%
		User user = (User) session.getAttribute("User");
		if (user != null) {
	%>
	<span> Hello <%=user.getUserId()%> 
	</span>
	<span><a href="dashboard.jsp">Home</a> |<a href="feeds.do">
			Feeds</a> | <a href="logout.do">Logout</a></span>
	<%
		} else {
	%>
	<span>Hi there</span>
	<%
		}
	%>
	<hr size="3" color="crimson">
</body>
</html>