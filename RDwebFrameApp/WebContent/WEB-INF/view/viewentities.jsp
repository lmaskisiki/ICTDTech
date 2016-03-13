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
	<form action="getEntities" method="post">
		<table>

			<tr>
				<td>Domain :</td>
				<td><select name="domainName">
						<option value="">Select</option>
						<c:forEach items="${domains}" var="dom">
							<option value="${dom.domainName}">${dom.domainName}</option>
						</c:forEach>

				</select></td>
				<td><input type="submit" value="View Entities" /></td>
			</tr>
		</table>

	</form>


			<c:forEach items="${entities}" var="ent" varStatus="theCount">
	<form action="getContent">
		<table border="1">
	 

				<tr style="width: 50xp;">


					<td align="center"
						style="width: 40px; border-bottom: 1px solid red;"><input
						type="hidden" name="getDataFrom" value="${ent.name}" /> <c:out
							value="${ent.name}"></c:out></td>
				
					<td><input type="submit" name ="viewContent" value="View Contents" /></td>




				</tr>

	</table>
	</form>
			</c:forEach>
	



</body>
</html>