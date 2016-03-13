<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

</style>
<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/formtags.css"/>" />
</head>
<body>

	<form action="assignrole">
	
	
		<input type="hidden" name="last_name" value="<c:out value="${profile.last_name }"/>" />
		<input type="hidden" name="first_name" value="<c:out value="${profile.first_name }"/>" />



		<table border="1" align="center">
			<tr>
				<td>Surname</td>
				<td>${profile.last_name }</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${profile.first_name }</td>
			</tr>

			<tr>
				<td>Cell Number</td>
				<td>${profile.cell}</td>
			</tr>

			<tr>
				<td>Email Address</td>
				<td>${profile.email}</td>
			</tr>

			<tr>
				<td>UserName</td>
				<td>${profile.username}
				<input type="hidden" name="username" value="${profile.username}" />
				</td>
			</tr>

			<tr>
				<td>Organizational Unit</td>
				<td>${profile.orgUnit}</td>
			</tr>
			<tr>
			<td>Roles</td>
			<td>
			<c:forEach  items="${rols}" var="rol">
			
			<li class="non_menulinks">${rol.role} <a  href="removerole?username=${profile.username}&role=${rol.role}">Remove</a></li>
			</c:forEach>
					
			</td>
			
			</tr>
			 <tr>
                <td>Assign Role: ${profile.member}</td>
                <td><select name="roleDN">

                        <c:forEach items="${roles}" var="role">
                            <option value="${role.groupDN}">${role.groupName}</option>

                        </c:forEach>

                </select>
                <input  class="button" type="submit"
                    value="Assign Role" /></td>
            </tr>
		</table>

	</form>

</body>
</html>