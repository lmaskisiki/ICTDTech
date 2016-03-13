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
<script type="text/javascript">
	function loadEntities() {

		var req = new XMLHttpRequest();

		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("results").innerHTML = req.responseText;
			}

		};

		var domain = document.getElementById("domainName").value;

		var query = "?domainName=" + domain;
		var url = "entupdate" + query;
		//alert(url);
		req.open("GET", url, true);
		req.send(null);

	}
	 

	function updateForm() {
 
		var req = new XMLHttpRequest();

		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("updateform").innerHTML = req.responseText;
			}

		};

		var entity = document.getElementById("entities").value;

		var query = "?entity=" + entity;
		var url = "updateForm" + query;
		//alert(url);
		req.open("GET", url, true);
		req.send(null);

	}
	 
</script>
</head>
<body>
<div  style="background-color: wheat;   width: 80%;  ">
	<form action="getContent" method="GET">
		<table   border="1">
			<tr>
				<td><select name="domainName" id="domainName"
					onchange="loadEntities()">
						<c:forEach items="${AllDomains}" var="domain">
							<option value="${domain.domainName}">${domain.domainName}</option>
						</c:forEach>
				</select></td>
				 
			</tr>
		</table> 
	</form>
	<hr/>
 
	<div id="results"  ></div>
	<div id="updateform"  ></div>
	
	</div>
</body>
</html>