<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="createDomain" method="GET">
		<table>
			<tr>
				<td>Creators' Full Name</td>
				<td><input align="middle" type="text" name="creator" /></td>

			</tr>

			<tr>
				<td>Domain Name</td>
				<td><input align="middle" type="text" name="name" /></td>
			</tr>

			<tr>
				<td>Domain Description</td>
				<td><textarea rows="4" cols="35" name="domainDescr"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create" /></td>
			</tr>
		</table>



	</form>
</body>
</html>