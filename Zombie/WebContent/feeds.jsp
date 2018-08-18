<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="banner.jsp" />
	<table align="center" width="50%" border="1" cellspacing="5">
		<tr>
			<th>Time</th>
			<th>Query</th>
			<th>Comments</th>
		</tr>

		<c:forEach items="${Feeds}" var="feed">
		<tr>
		<td>${feed.timefeed }</td>
		<td><a href="question.do?id=${feed.feedId}">${feed.question }</a></td>
		<td>${feed.totalCmnts }</td>
		</tr>
		</c:forEach>
		
</body>
</html>