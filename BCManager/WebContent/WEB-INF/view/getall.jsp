<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>find all</title>
</head>
<body>
	<table class="table table-condensed">

		<thead>
			<tr>
				<td>Names</td>
				<td>Surname</td>
				<td>Id Number</td>
				<td>Registration Date</td>

			</tr>

		</thead>
		<tbody>

			<c:forEach items="${results}" var="item">
				<tr>
					<td>${item.bcNumber}</td>
					<td>${item.childNames}</td>
					   <td>${item.surname}</td>
					       <td>${item.gender}</td>
					          <td>${item.creationDate}</td>
					
                        <td><a href="edit/${item.bcNumber}">Edit</a></a></td>
                                <td><a href="#">Delete</a></a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


</body>
</html>