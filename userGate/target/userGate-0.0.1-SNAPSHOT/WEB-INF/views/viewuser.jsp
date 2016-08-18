<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/css/formtags.css"/>" />
</head>

<body>

	<table>
		<tr>
			<td>Surname</td>
			<td>${last_name }</td>

			<td>${first_name }</td>

			<td>${ cell}</td>

			<td>${ email}</td>

			<td>${username}</td>
			<td><a class="non_menuAnca" href="${username}">Edit</a></td>
		</tr>

	</table>
</body>
</html>