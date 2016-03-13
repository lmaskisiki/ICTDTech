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
	<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/table1.css"/>" />
</head>
<script type="text/javascript">
	
</script>
<body>
	<div class="wrapper">
		<div id="header">

			<%@ include file="adminheader.jsp"%>
		</div>

		<div class="content">
			<div id="left"></div>
			<div id="main">
				<div>
					<div id="contentTable">
						<table>
							<thead>
								<tr>
									<c:forEach items="${labels}" var="lbl">
										<th>${lbl}
									</c:forEach>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${data}" var="list">
									<tr>
										<c:forEach items="${list}" var="item">
											<td>${item}</td>
										</c:forEach>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
				</div>

			</div>
			<div id="right"></div>

		</div>
		<div id="footer"></div>
	</div>







</body>
</html>