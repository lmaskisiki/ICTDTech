<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

  


</script>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<table class="table table-condensed">
		<tbody>
			<tr>
				<td>Surname</td>
				<td>${person.lastName}</td>
			</tr>
			<tr>
				<td>Name(s)</td>
				<td>${person.firstName}</td>
			</tr>
			<tr>
				<td>Username</td>
				<td>${person.username}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${person.gender}</td>
			</tr>
			<tr>
				<td>Cell</td>
				<td>${person.cell}</td>
			</tr>
			<tr>
				<td>Dn</td>
				<td>${person.dn}</td>
			</tr>
		</tbody>
	</table>

	<hr />
	<div>
	 
			<c:forEach items="${documents}" var="doc">
			 <div>
			 	 <input type="hidden" id="filepath" value="${doc.filePath}"/>
				${doc.fileName} :<a href="ftp://localhost/${doc.filePath}">Open</a> 
			<a href="#" id="showpdf" >Show Here</a> 
				 <div id="pdfview"></div>
			 </div>
			</c:forEach>
	 

	</div>
	<hr />
	<div><button value="${person.firstName} ${person.lastName}" id="approve"  >Approve</button> <span id="updaterespose"></span></div>
	<script type="text/javascript"
		src="/BCManager/resources/bootstrap/js/bootstrap.js">
		
	</script>
	<script type="text/javascript"
		src="/BCManager/resources/bootstrap/js/bootstrap.min.js">
		
	</script>
	<script type="text/javascript"
		src="/BCManager/resources/bootstrap/js/jquery-1.12.4.min.js">
		
	</script>

	<script type="text/javascript" src="/BCManager/resources/js/ajaxcallprocessor.js">
	</script>

</body>

</html>
