<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/theme/css/layout.css"/>" />

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
						}
					}
				}
			};
			var query = "?domain= " + dmain;
			xhttprequest.open("GET", "getEntities" + query, true);
			xhttprequest.send(null);
		}

	}

	function loadAttributes() {
		var ent = document.getElementById("entity").value;
		var select = document.getElementById("attribute");
		var element = document.createElement("option");
		var xhttprequest = new XMLHttpRequest();
		xhttprequest.onreadystatechange = function() {
			if (xhttprequest.readyState == 4) {
				if (xhttprequest.status == 200) {
					element.innerHTML = "SELECT ONE";
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
					}

				}

			}

		};

		var query = "?entity= " + ent;
		xhttprequest.open("GET", "getAttributes" + query, true);
		xhttprequest.send(null);
	}
	//showreference()
	function showreference() {
		var dmain = document.getElementById("domain").value;
		var select = document.getElementById("referenceEntity");
		if ((domain != "") || (domain != null)) {
			var xhttprequest = new XMLHttpRequest();
			var element = document.createElement("option");
			element.innerHTML = "SELECT ONE";
			xhttprequest.onreadystatechange = function() {
				if (xhttprequest.readyState == 4) {
					if (xhttprequest.status = 200) {
						document.getElementById("references").style.display = "block";

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
						}
					}
				}
			};
			var query = "?domain= " + dmain;
			xhttprequest.open("GET", "getEntities" + query, true);
			xhttprequest.send(null);
		}

	}

	function loadReferenceAttributes() {
		var ent = document.getElementById("referenceEntity").value;
		var select = document.getElementById("referenceAttribute");
		var element = document.createElement("option");
		var xhttprequest = new XMLHttpRequest();
		xhttprequest.onreadystatechange = function() {
			if (xhttprequest.readyState == 4) {
				if (xhttprequest.status == 200) {
					element.innerHTML = "SELECT ONE";
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
					}

				}

			}

		};

		var query = "?entity= " + ent;
		xhttprequest.open("GET", "getAttributes" + query, true);
		xhttprequest.send(null);
	}

	function showSubmit() {

		document.getElementById("submitButton").style.display = "block";

	}
</script>

<body>

	<div>
		<form action="addrelationships" method="get">
			<div id="selectionArea"  style="background-color: wheat;">

				<table cellspacing="5" >
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
						<td><select name="entity" id="entity"
							onchange="loadAttributes()">
								<option value="">SELECT ONE</option>

						</select></td>
						<td>Attribute</td>
						<td><select name="attribute" id="attribute"
							onchange="showreference()">
								<option value="">SELECT ONE</option>

						</select></td>
					</tr>
				</table>
				<table  cellspacing="5" >
					<tr id="references" style="display: none">

						<td>Reference Table</td>
						<td><select name="referenceEntity" id="referenceEntity"
							onchange="loadReferenceAttributes()">
								<option value="">SELECT ONE</option>

						</select></td>

						<td>Attribute</td>
						<td><select name="referenceAttribute" id="referenceAttribute"
							onchange="showSubmit()">
								<option value="">SELECT ONE</option>

						</select></td>
					</tr>


					<tr>
						<td colspan="3"><input type="submit" id="submitButton" align="middle"
							value="Relate Entities" style="display: none" /></td>
					</tr>
				</table>
			</div>

		</form>

	</div>

</body>
</html>