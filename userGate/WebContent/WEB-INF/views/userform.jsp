<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user info form</title>
<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/formtags.css"/>" />
</head>

<%@include file="header.jsp"%>
<body>
	<h3
		style="border: 1px solid greeb; color: blue; text-align: centet; page-break-after: always;">Please
		fill the form below</h3>

	<br />
	<form action="submit_appl" method="get">


		<table border="1">

			<tr>
				<td>Surname</td>
				<td><input type="text" name="last_name" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="first_name" /></td>
			</tr>
			<tr>
				<td>Cell</td>
				<td><input type="text" name="cell" /></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
				<td><input  class="button" type="submit" value="Submit Application" /></td>
			</tr>
		</table>


	</form>
</body>
</html>