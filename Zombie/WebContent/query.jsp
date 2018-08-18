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
	<h1>Ask Question</h1>
	<hr size="3" color="crimson">
	<form action="query.do" method="Post">
		<textarea name="query" rows="5" cols="30"></textarea>
		<br> <input type="submit" value="Ask">
	</form>
</body>
</html>