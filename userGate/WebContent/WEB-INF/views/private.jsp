<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
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
	<h4>Hello ${user} , Welcome to your page</h4>
	<ul>
		<security:authorize ifAllGranted="ROLE_User">
			<li><a href="profile/edit/${user}">Profile</a></li>
		</security:authorize>
		<security:authorize ifAllGranted="ROLE_Admin">
			<li><a href="migrateUser">Assign Roles</a></li>
			<li><a href="#">Burn Account</a></li>
			<li><a href="#">Find Someone</a></li>
		</security:authorize>
	</ul>

</body>
</html>