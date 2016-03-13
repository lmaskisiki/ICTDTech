<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
th {
	text-align: left;
	background-color: blue;
	color: white;
	font-size: 14pt;
	border: 1px solid red;
	border-style: outset;
}

input {
	background-color: wheat;
	border-style: inset;
	text-align: left;
}
</style>
</head>
<body>

	<form action="addDataType" method="get">
		<table border="1">

			<tr>
				<th>Name</th>
				<td><input type="text" size="10" name="name" /></td>
			</tr>
			<tr>
				<th>Type</th>
				<td><input type="text" size="10" name="type" /></td>
			</tr>
			<tr>
				<th>Default Size</th>
				<td><input type="text" size="3" name="defaultSize" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Create Type" /></td>
			</tr>
		</table>


	</form>

</body>
</html>