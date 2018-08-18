<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Change Password</h3>
	
	<form action="forget.do" method="get">

		<table width="400" align="center">
			<tr>
				<!-- <h3>What is your favourite Movie?</h3> -->
				<br>
				<!-- <td center="align">Movie Name: <input type="text" name="movie"></td>
			</tr>-->
			<tr>
				<td center="align">User Id:<input type="text" name="userId"><br></td>
			</tr> 
			<tr>
				<td center="align">Email:<input type="email" name="email"><br></td>
			</tr> 
			
			<tr>
				<td><input type="submit" value="Proceed" ></td>
			</tr>
		</table>
	</form>
	<%@ include file="footer.html"%>
</body>
</html>