<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/formtags.css"/>" />
</head>
<body>
 <%@include file="header.jsp" %>
<table>


<c:forEach items="${found}" var="person">
    <tr>
      <td>${person.last_name}</td>
      <td>${person.first_name}</td>
      <td>${person.username }</td>
      <td>${person.email }</td>
      <td>${person.cell}</td>
    </tr>
 </c:forEach>
	</table>	
	
	

</body>
</html>