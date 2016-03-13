<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/layout.css"/>" />
</head>



<body>

	<div class="wrapper">
		<div id="header">
<%@ include file="adminheader.jsp"%>

		</div>

		<div class="content">
			<div id="left"></div>
			<div id="main">
			
			<table>
		<tr>
			<td>Domain</td>
			<td>${domain}</td>
		</tr>
		<tr>
			<td>Entity</td>
			<td>${entity}</td>
		</tr>
		<tr>
			<td>Access Type</td>
			<td>${access}</td>
		</tr>
		<tr>
			<td>Attributes</td>
			<td>${attributes}</td>
		</tr>
		<tr>
			<td>Data Types</td>
			<td>${types}</td>
		</tr>
		<tr>
			<td>Custom Fields</td>
			<td>${customfields}</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a
				href="destroyentity?entity=${entity}">Start Over</a></td>
		</tr>
	</table>
			</div>
			<div id="right"></div>

		</div>
		<div id="footer"></div>
	</div>


</body>
</html>