<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
<tr  bgcolor="grey"  style="border-style: outset">
<c:forEach  items="${labels}"   var="column">
			<th>${column}</th>
</c:forEach>
</tr>
		<c:forEach items="${data}" var="list">
			<tr>
				<c:forEach items="${list}" var="item">
					<td>${item}</td>

				</c:forEach>
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