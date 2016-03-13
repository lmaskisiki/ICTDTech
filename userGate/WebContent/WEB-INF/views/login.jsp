<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="loginproces"  method="post">
<b>Please Login Below</b>
		<table>
		<thead>
		</thead>
		<tr><td>Username</td><td><input type="text" name="username"/></td></tr>
		<tr><td>Password</td><td><input type="text" name="password"/></td></tr>
		<tr><td><input type="Submit" value="Login"/></td></tr>
		</table>
${results}
${user.last_name}
${user.first_name}
</form>
</body>
</html>