<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="thistle" text="indigo">
	<jsp:include page="banner.jsp" />
	<h1>My Dashboard</h1>
	<hr size="1" color="crimson">
	User Id: ${User.userId}
	<br> Email: ${User.email}
	<br> Total Feeds: ${User.totalFeeds}
	<br />
	<a href="query.jsp">Ask Question</a>
</html>