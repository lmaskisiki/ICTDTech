<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table {
	width: 95%;
	font-family: verdana, arial, sans-serif;
	font-size: 12px;
	color: #333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
	margin: 0 auto;
}

table  th {
	background: #b5cfd2;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}

table td {
	background: #dcddc0 url('cell-grey.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/layout.css"/>" />
</head>
<body>
	<%@ include file="adminheader.jsp"%>

	<div class="wrapper">
		<div id="header">

			<ul id="nav">
				<li><a href="newEntity">Create Entity</a></li>
				<li><a href="viewcontentrequest">Show Content</a></li>
				<li><a href="update">Update Content</a></li>
				<li><a href="entityrelation">Associations</a></li>
				<li><a href="createdomainrequest">Create Domain</a></li>
			</ul>
		</div>

		<div class="content">
			<div id="left"></div>
			<div id="main">
			
			
				<table border="1" align="center">
		<tr bgcolor="grey">
			<th>Domain ID</th>
			<th>Domain Name</th>
			<th>Domain Creator</th>
			<th>Category</th>
		</tr>
		<c:forEach var="domain" items="${domains}">


			<tr>
				<td>${domain.domainId}</td>
				<td>${domain.domainName}</td>
				<td>${domain.creator}</td>
				<td>${domain.category}</td>
				<td id="action"><a
					href="editdomain?domainId=${domain.domainId}">Edit</a></td>
				<td id="action"><a
					href="destroydomain?domainId=${domain.domainId}">Destroy</a></td>

			</tr>



		</c:forEach>
	</table>
			
			
			
			
			
			
			</div>
			<div id="right"></div>

		</div>
<div id="footer"></div>
	</div>


</body>
</html>