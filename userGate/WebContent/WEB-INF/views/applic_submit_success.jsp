<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/css/formtags.css"/>" />
</head>
<%@include file="header.jsp"%>
<body>
	<b style="color: blue; text-align: center;"> The person object with
		the following attributes has succussfully applied for an account </b>

	<br />
	<table border="1" style="background-color: wheat;">
		<tr>
			<td>Surname</td>
			<td>${last_name }</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${first_name }</td>
		</tr>
		<tr>
			<td>Cell Number</td>
			<td>${ cell}</td>
		</tr>
		<tr>
			<td>email Address</td>
			<td>${ email}</td>
		</tr>
		<tr>
			<td>Username</td>
			<td>${ username}</td>
		</tr>

	</table>
</body>
</html>