<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Basic Bootstrap Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="/BirthTech/resources/bootstrap/css/bootstrap.min.css">
<!-- Optional Bootstrap theme -->
<link rel="stylesheet"
	href="/BirthTech/resources/bootstrap/css/bootstrap-theme.min.css">
</head>
<body>

	<div class=”container”>
		<div id="nav">
			<ul class="nav nav-tabs">
					<li><a href="http://localhost:8080/BirthTech/">Home</a></li>
			</ul>
		</div>
		<div id="main">
		<form action="add" method="get">
			<table class="table table-condensed">

				<tr>
					<td>Surname</td>
					<td><input type="text" name="surname"></input></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="names"></input></td>
				</tr>
				<tr>
					<td>Id Number</td>
					<td><input type="text" name="idNumber"></input></td>
				</tr>
				<tr>
					<td>Employment Status</td>
					<td><select name="employementStatus">
							<option value="">Select</option>
							<option value="GOVERNMENT">Government</option>
							<option value="SELF">Self</option>
							<option value="PRIVATE">Private</option>
							<option value="UNEMPLOYED">Unemployed</option>
					</select></td>
				</tr>
				<tr><td colspan="2"><input type="submit"  value="Add Maternity"/></td></tr>
			</table>
			</form>
		</div>
	</div>

	<script src="/BirthTech/resources/bootstrap/js/jquery-2.1.1.min.js"></script>
	<script src="/BirthTech/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>