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



	<form action="updateForm" method="post">

		<table>

			<tr>
				<td><select name="getDataFrom">
					<c:forEach items="${entities}" var="entity">
							<option value="${entity.name}">${entity.name}</option>
						</c:forEach>
				</select></td>
				
				<td><input  type="submit"  value="Add Content"/></td>
			</tr>
			
		</table>
	</form>



</body>





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
			
			</div>
			<div id="right"></div>

		</div>
<div id="footer"></div>
	</div>


</body>
</html>