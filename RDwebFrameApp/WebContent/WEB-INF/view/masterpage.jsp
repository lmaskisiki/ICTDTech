<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	width: 100%;
}

#head {
	background-color: lightgrey;
	height: 80px;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
	border-bottom: 2px solid blue;
	position: relative;
	text-align: center;
}

#buttons {
	width: 80%;
	background-color: wheat;
	margin-left: auto;
	margin-right: auto;
}

#formContainer {
	width: 100%;
	height: 40px;
	overflow: visible;
	margin-left: auto;
	margin-right: auto;
	background-color: black;
	opacity: 0.5;
}

#formContainer form {
	padding-top: 8px;
	padding-left: 25px;
	float: left;
}
</style>
</head>
<body>


	<div id="head">

		<b><i style="font-size: 24pt;"> AmaHlubi ICT4D</i></b> <br /> <small>Customize,
			Integrate and Provide </small>

<a href="logout">Logout</a>
<a></a>
	</div>

	<div id="buttons">


		<div id="formContainer">

			<form action="domainLoginRequest" method="POST">

				<input type="submit" value="Domain Login" />
			</form>

			<form action="viewAll" method="post">
				<input type="submit" value="Find All" />
			</form>

			<form action="addDataType" method="post">
				<input type="submit" value="New DataType" />
			</form>

			<form action="showMap" method="POST">
				<input type="submit" value="Map View" />
			</form>
			<form action="entityRelation" method="POST">
				<input type="submit" value="Relationships" />
			</form>

			<form action="newEntity" method="POST">
				<input type="submit" value="Create Entity" />
			</form>

			<form action="update" method="POST">
				<input type="submit" value="Update Conent" />
			</form>
			<form action="viewcontentrequest" method="get">
				<input type="submit" value="Load Conent" />
			</form>

			<form action="entityrelation" method="post">
				<input type="submit" value="Add Associations" />
			</form>
			<form action="createdomainrequest" method="POST">
				<input type="submit" value="New Domain" />
			</form>

		</div>
	</div>
<h1>Hello Master How Are today</h1>
</body>
</html>