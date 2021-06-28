
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Magazines Shop register</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h1>Registration</h1>

<form action="register" method="post">
    <input name="firstName" type="text" placeholder="First Name"><br>
    <input name="lastName" type="text" placeholder="Last Name"><br>
    <input name="password" type="text" placeholder="Password"><br>
    <input name="email" type="text" placeholder="Email"><br>
    <p>User</p>
    <input name="access" type="radio" id="user" checked><br>
    <p>Admin</p>
    <input name="access" type="radio" id="admin"><br>
    <input type="submit" value="Submit">
</form>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
