<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="thistle" text="indigo">
<jsp:include page="banner.jsp" />
<h1>Login Screen</h1><hr size="3" color="crimson">
		<form action="login.do" >
		<font color="crimson">${Prompt}</font>
			<table width="400" align="center">
				<tr>
					<td center="align">User id:<input type="text" name="userId"><br></td>
				</tr>
				<tr>
					<td center="align">Password: <input type="password" name="password" required></td>
				</tr>
				<tr ><td><input type="submit" value="Login"></td></tr>
				
				<tr><td ><a href="forget.jsp">Forget password! Change here</a></td></tr>
				<tr><td ><a href="register.jsp">New User! Register</a></td></tr>
			</table>
	</form>
</body>
</html>