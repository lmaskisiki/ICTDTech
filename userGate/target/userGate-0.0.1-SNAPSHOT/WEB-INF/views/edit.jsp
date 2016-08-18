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
	<h4>Hello ${user} , Welcome to your page</h4>
	<form action= "update" method="get">

		<table>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last_name"
					value="${person.last_name }" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first_name"
					value="${person.first_name }" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><input type="text" name="cell"
					value="${person.cell}" /></td>
			</tr>
			<tr>
                <td>Username</td>
                <td><input type="text" name="username"
                    value="${person.username}" /></td>
            </tr>
			<tr>
				<td>Email Address</td>
				<td><input type="text" name="email"
					value="   ${person.email}" /></td>
			</tr>
			<tr>
				<td>User Dn</td>
				<td><input type="text" name="dn"
					value="${person.dn }" /></td>
			</tr>
			 <tr>
                <td>User Roles</td>
                <td>
                <c:forEach items="${roles}"  var="role">
                ${role.role}
                </c:forEach>
                
                </td>
            </tr>
			<tr>
                <td colspan="2"><input  class="button" type="submit" value="Update"/></td>
            </tr>
		</table>


	</form>

</body>
</html>