<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/table1.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/menu.css"/>" />
</head>
<body>
	<div class="wrapper">
		<div id="nav">


			<ul id="menu">
				<li><a href="#">Account</a>
					<ul id="nav-drop">
						<li><a href="#">Login</a></li>
						<li><a href="#">Sign Up</a></li>
					</ul></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Report Issues</a></li>
				<li><a href="web/admin">Domain</a></li>
			</ul>

		</div>

		<div id="container">
			<div id="sidebar1"></div>
			<div id="main">
<form action="savepost" method="get">
				<table>
					<tr>
						<td>Category</td>
						<td><select name="category">
								<option value="">Please Select</option>
								<c:forEach items="${categories}" var="cat">
									<option value="${cat}">${cat}</option>
								</c:forEach>
						</select></td>

						<td>Domain Info.</td>
						<td><select name="domain">
								<option value="">Please Select</option>
								<c:forEach items="${domains}" var="dom">
									<option value="${dom.domainName}">${dom.domainName}</option>
								</c:forEach>
						</select></td>

					</tr>
					<tr>
						<td>Title</td>
						<td colspan="3"><input type="text" size="80" name="title" /></td>
					</tr>
					<tr>
						<td>Body</td>
						<td colspan="3"><textarea cols="80" rows="10" name="body"></textarea></td>
					</tr>



					<tr>
						<td>Author</td>
						<td colspan="3"><input type="text" value="${user}"
							name="author" readonly="readonly" /></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="submit"
							value="Save Post" align="middle" /></td>
					</tr>
				</table>


</form>
			</div>
			<div id="sidebar2"></div>
		</div>

	</div>
</body>
</html>