<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var domain = document.getElementById("activeDomain").value;
	function change() {
		//	alert(document.getElementById("activeDomain").value);
		var req = new XMLHttpRequest();

		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("entityCreate").innerHTML = " "
						+ req.responseText + "";

			}

		};

		var query = "?activeDomain="
				+ document.getElementById("activeDomain").value;

		req.open("GET", "activeDomain" + query, true);
		req.send(null);

	}

	function loadContent() {
		var actEnt = document.getElementById("activeEntity").value;

		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("contentDiv").innerHTML = " "
						+ req.responseText + " ";

			}

		};

		var query = "?activeEntity=" + actEnt;
		//alert("button clicked"+actEnt);
		req.open("GET", "viewContent" + query, true);

		req.send(null);

	}

	function addOptions(id) {
		alert(id);
	}
</script>

<body>

	<div id="entityPanel"
		style="background-color: wheat; border: 2px solid red; align: center; text-align: center; width: 80%; margin-left: auto; margin-right: auto;">
		<div id="entityList" align="center">
			<form action="showentities" method="get">
				<table>
					<tr>
						<td>Select Domain</td>
						<td><select onchange="change()" id="activeDomain"
							name="activeDomain">
								<option value="">Please Select</option>
								<c:forEach items="${domains}" var="domain">
									<option value="${domain.domainName}"><c:out
											value="${domain.domainName}"></c:out></option>
								</c:forEach>
						</select></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="entityCreate" align="center"></div>
		<div id="contentDiv" align="center"></div>
		<div>
			<table border="1" align="center">
				<tr bgcolor="grey" style="border-style: outset">
					<c:forEach items="${labels1}" var="column">
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
	</div>








	<table>
	
	
		<tr>
	<td>cscid</td><td> <select name='value'></select></td>
	</tr>
	
	
		<tr>
		<td>cscname</td><td><input type='text' name='values' /></td>
		</tr>
		
		<tr>
		<td>sex</td><td><input type='text' name='values' /></td>
		</tr>
		<tr>
		<td>gender</td><td><input type='text' name='values' /></td>
		
		</tr>
		
		
		
		</table>





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


</body>
</html>