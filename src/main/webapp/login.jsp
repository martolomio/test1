<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<form action="ServletLogin" method="post">
		<input name= "login" type= "text" placeholder="Email">
		<br>
		<br>
		<input name = "password" type= "text" placeholder="Password">
		<br>
		<br>
		<input type = "submit" value="Enter">

	</form>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>