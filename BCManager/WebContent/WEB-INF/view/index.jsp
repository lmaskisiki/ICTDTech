<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap-theme.min.css">
<style type="text/css">
body {
	background-color: buttonface;
}

.wrapper {
	width: 100%;
	margin: 1px;
	border: 1px solid blue;;
	border-style: outset;
	display: block;
	overflow: auto;
}

#main {
	width: 70%;
	float: left;
}

#sidebar {
	width: 30%;
	float: right;
	overflow: auto;
}

.feedbody {
	display: none;
}
</style>
</head>
<body>

	<div class="wrapper">
		<div id="Header">
			<a href="account/create">Create</a> <a href="#"
				onclick="loadUserProfile()">My Profile</a> <a href="#">mxm</a> <a
				href="#" onclick="updateprofile()">Profile Update</a>
			<button>button</button>
		</div>
		<div id="main">
		
		</div>
		</div>





	
		<script src="resources/js/jquery-1.12.4.min.js"></script>
		<script src="resources/bootstrap/js/bootstrap.min.js"></script>
		<script src="resources/js/eventhander.js"></script>
		<script src="resources/js/namingconversion/personproperties.js"></script>
		<script src="resources/js/ajaxcallprocessor.js"></script>
		
</body>
</html>