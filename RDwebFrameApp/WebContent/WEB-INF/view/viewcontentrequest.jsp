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
<script type="text/javascript">
function addEntityOptions() {
	var dmain = document.getElementById("domain").value;
	var select = document.getElementById("entity");
	if ((domain != "") || (domain != null)) {
		var xhttprequest = new XMLHttpRequest();
		var element = document.createElement("option");
		element.innerHTML = "SELECT ONE";
		xhttprequest.onreadystatechange = function() {
			if (xhttprequest.readyState == 4) {
				if (xhttprequest.status = 200) {
					var obj = JSON.parse(xhttprequest.responseText);

					while (select.firstChild) {
						select.removeChild(select.firstChild);
					}

					select.appendChild(element);
					for (var x = 0; x < obj.length; x++) {
						var optionValue = document.createElement("option");
						optionValue.value = obj[x];
						optionValue.innerHTML = obj[x];
						select.appendChild(optionValue);
						document.getElementById("submitButton").style.display="inline";
					}
				}
			}
		};
		var query = "?domain= " + dmain;
		xhttprequest.open("GET", "getEntities" + query, true);
		xhttprequest.send(null);
	}

}
</script>


	<div class="wrapper">
		<div id="header">
				<%@ include file="adminheader.jsp"%>
		</div>

		<div class="content">
			<div id="left"></div>
			<div id="main">
			<div>
	<form action="viewcontent"  method="get"> 
		<table>
			<tr>
				<td>Domain</td>
				<td><select name="domain" id="domain"
					onchange="addEntityOptions()">
						<option value="">SELECT ONE</option>
						<c:forEach items="${domains}" var="dom">
							<option value="${dom.domainName}">${dom.domainName}</option>
						</c:forEach>
				</select></td>
				<td>Entity</td>
				<td><select name="entity" id="entity">
						<option value="">SELECT ONE</option>

				</select></td>
				
				<td><input type="submit" value="View"  id="submitButton" style="display:none;"/></td>
 			</tr>
		</table>
	</form>
	</div>
			</div>
			<div id="right"></div>

		</div>
<div id="footer"></div>
	</div>

</html>