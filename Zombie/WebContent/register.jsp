<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="banner.jsp"/>
	<form action="register.do">
		<table width="400" align="center">
			<tr>
				<th colspan="2">Registration Form</th>
			</tr>
			<tr>
				<td align='center'><label for="name"><b>User_id: </b></label></td>
				<td><input type='text' placeholder="Enter Your User_id"
					name="userId" required></td>
			</tr>
			<tr>
				<td align='center'><label for="email"><b>Email: </b></label></td>
				<td><input type="text" placeholder="Enter Email" name="email"
					pattern="[^ @]*@[^ @]*" required></td>
			</tr>
			<tr>
				<td align='center'><label for="password"><b>Password:</b></label></td>
				<td><input type="password" placeholder="Enter Password"
					name="password" required
					title="Must contain at least one number and one uppercase and lowercase letter, 
    		and at least 8 or more characters"></td>
			</tr>


			<tr>
				<th colspan="2"><input type="submit" value="Register"></th>
			</tr>
		</table>

		<%@ include file="footer.html"%>

	</form>

</body>
</html>