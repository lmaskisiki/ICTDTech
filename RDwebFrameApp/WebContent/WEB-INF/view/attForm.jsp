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
	<b>ATT fORM</b> ${numOfAtt}
	
	 
	
	
	<form action="create"  method="get">
<table  align="center"   border="1">
<tr  bgcolor="grey">
<th>Domain Name</th>
<th>Creator</th>
<th>Attributes</th>
</tr>
<tr>
<td><input type="text"  value="${domainName}"  name="name"/></td>
<td><input type="text" value="${creator}" name="creator"/></td>
<td><input type="text"  value="${numOfAtt}"   size="3" name="numOfAtt"/></td>

</tr>

</table>
		<table border="1" align="center">

			<tr>
				<th>Attribute Name</th>
				<th>Data Type</th>
				<th>Length</th>
			</tr>
			<c:forEach begin="1" end="${numOfAtt}" var="att">
				<tr>
					<td><input type="text" name="name${att}" value="name${att}" /></td>
					<td><select name="dtype${att}">

							<c:forEach items="${dtypes}" var="dtype">
								<option value="${dtype}">${dtype}</option>
							</c:forEach>
					</select></td>
					<td><input type="text" size="5" name="length${att}" /></td>
				</tr>


			</c:forEach>
			<tr bgcolor="wheat">
				<td colspan="3" align="center"><input type="submit"
					value="Continue" /></td>

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