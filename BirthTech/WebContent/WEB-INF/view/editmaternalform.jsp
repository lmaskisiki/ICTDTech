<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit</title>
</head>
<body>
	<div id="container">
		<form action="">
			<input type="hidden" name="mid" value="${maternal.mid}" />
			<table>
				<tr>
					<td>Names</td>
					<td><input type="text" value="${maternal.names}" /></td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><input type="text" value="${maternal.surname}" /></td>
				</tr>
				<tr>
					<td>Id Number</td>
					<td><input type="text" value="${maternal.idnumber}" /></td>
				</tr>
				<tr>
					<td>Nurse</td>
					<td><input type="text" value="${maternalt.nurse}"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Registration Date</td>
					<td><input type="text" value="${maternal.registration}"
						readonly="readonly" /></td>
				</tr>

			</table>

		</form>


	</div>
</body>
</html>