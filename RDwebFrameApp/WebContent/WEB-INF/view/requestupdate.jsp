<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/layout.css"/>" />
</head>
<body>
	${domainName} domain name
	<form action="updateForm" method="post">
		<input type="hidden" name="domainName" value="${domainName}" />
		<table>
			<tr>
				<td><select name="object">
						<c:forEach items="${tables}" var="table">
							<option value="${table}">${table}</option>


						</c:forEach>



				</select></td>
				<td><input type="submit" value="Update This" /></td>
			</tr>

		</table>

	</form>

	<form action="newEntity" method="post"
		style="background-color: green; border: 1px solid red;">
		<input type="hidden" name="domainName" value="${domainName}" />
		<table>
			<tr>
				<td>Create the Entity in :</td>
				<td><select name="domain">
						<c:forEach items="${tables}" var="table">
							<option value="${table}">${table}</option>

						</c:forEach>



				</select></td>
			</tr>
			<tr>
				<td>Number of Attributes</td>
				<td><input type="text" name="count_attributes" size="3" /></td>

			</tr>
			<tr>
				<td><input type="submit" value="Create New Entity Here" /></td>
			</tr>

		</table>

	</form>




</body>
</html>