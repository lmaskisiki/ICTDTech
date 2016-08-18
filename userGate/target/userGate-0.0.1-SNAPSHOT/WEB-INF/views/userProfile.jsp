<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/formtags.css"/>" />
</head>
<body>

	<form action="selfUpdate" method="get">

		<input type="hidden" name="last_name"
			value="<c:out value="${user.last_name}"/>" /> <input type="hidden"
			name="first_name" value="<c:out value="${user.first_name}"/>" />
		<table border="1">
			<tr>
				<td>Surname</td>
				<td>${user.last_name}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${user.first_name}</td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><input type="text" name="email"
					value="<c:out value="${user.email}"/>" /></td>
			</tr>
			<tr>
				<td>Cell Number</td>
				<td><input type="text" name="cell"
					value="<c:out value="${user.cell}"/>" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input class="button" type="submit"
					value="Update" /></td>
			</tr>
		</table>

	</form>
</body>
</html>