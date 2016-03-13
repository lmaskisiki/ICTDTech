<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 
<body>

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
			
	<form action="saveUpdate" method="post">
	<input type="hidden"  name="attrNumber"  value="${attrNumber}"/>
	<input type="hidden"  name="entity"  value="${entity}"/>
	<input type="hidden"  name="domainName"  value="${domainName}"/>
 
		<table>
			<tr>
				<th>Attribute</th>
				<th>Value</th>
			</tr>
			<c:forEach items="${attributes}" var="attribute" varStatus="attCount">
				<tr>
					<td>${attribute}</td>
					<td><input type="text" name="attribute" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Upload" /></td>
			</tr>
		</table>
	</form>
			
			</div>
			<div id="right"></div>

		</div>
<div id="footer"></div>
	</div>


</body>





</html>