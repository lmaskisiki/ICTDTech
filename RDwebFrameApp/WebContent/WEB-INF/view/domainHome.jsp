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

<script type="text/javascript">
	function loadEntities() {

		var domain = document.getElementById("domainFound").value;
		if (domain == "") {
			document.getElementById("entitiesFound").innerHTML = "";

		} else {
			var xhttprequest = new XMLHttpRequest();
			xhttprequest.onreadystatechange = function() {
				if (xhttprequest.readyState == 4) {

					if (xhttprequest.status = 200) {
						document.getElementById("entitiesFound").innerHTML = xhttprequest.responseText;
						showButtons();
					}
				}
			};
			var query = "?activeDomain=" + domain;
			xhttprequest.open("GET", "showEntities" + query, true);
			xhttprequest.send(null);
		}
	}
	function showButtons() {
		var newEntityButton = "<input type='button' value='New Entity' onclick='newEntity()'  />";
		document.getElementById("newEntityButton").innerHTML = newEntityButton;
	}
	function showOptions() {
		var entityOptions = "<table><tr><td><input type='button'  value='View Content' onclick='showContent()' /></td><td><input type='button'  value='Update Content' onclick='updateContent()' /></td></tr></table>";
		document.getElementById("entityOptions").innerHTML = entityOptions;

	}

	function showContent() {
		var actEnt = document.getElementById("activeEntity").value;

		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("mainHolder").innerHTML = " "
						+ req.responseText + " ";

			}

		};

		var query = "?activeEntity=" + actEnt;
		//alert("button clicked"+actEnt);
		req.open("GET", "viewContent" + query, true);

		req.send(null);

	}

	function updateContent() {

		var req = new XMLHttpRequest();

		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("mainHolder").innerHTML = req.responseText;
			}

		};
		var actEnt = document.getElementById("activeEntity").value;
		var query = "?entity=" + actEnt;
		var url = "updateForm" + query;
		//alert(url);
		req.open("GET", url, true);
		req.send(null);

	}

	function newEntity() {

		var req = new XMLHttpRequest();

		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("mainHolder").innerHTML = req.responseText;
			}

		};
		var domain = document.getElementById("domainFound").value;
		var query = "?domain=" + domain;
		var url = "newEntity" + query;
		//alert(url);
		req.open("POST", url, true);
		req.send(null);

	}

	function addRows() {

		var table = document.getElementById('entityAttributes');
		var row = document.getElementById("entityRows"); // find row to clone
		var clonedRow = row.cloneNode(true);
		//clonedRow.id = "newID"; // change id or other attributes/contents
		//table.appendChild(clonedRow); // add new row to end of table
		var lastRow = table.insertRow(Math.floor(table.rows.length));
		var cell1 = lastRow.insertCell(0);
		cell1.appendChild(clonedRow);

	}

	function showFK_entities() {
		var domain = document.getElementById("FK_domain").value;
		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("FK_entity").innerHTML = req.responseText;
			}
		};

		var query = "?activeDomain=" + domain;
		var url = "loadEntities" + query;

		req.open("GET", url, true);
		req.send(null);

	}
	//showAtrributes  activeEntity

	//this one loads attributes for the selected entity
	function showAttributes() {
		var entity = document.getElementById("entity").value;

		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("FK_attribute").innerHTML = req.responseText;
			}
		};

		var query = "?entity=" + entity;
		var url = "loadTableAtrributes" + query;

		req.open("GET", url, true);
		req.send(null);

	}
	// loadAttributeTypes  activeAttribute entity

	//this one loads datatype for the selected attribute
	function loadAttributeType() {
		var entity = document.getElementById("entity").value;
		var attribute = document.getElementById("activeAttribute").value;

		var req = new XMLHttpRequest();
		req.onreadystatechange = function() {
			if (req.readyState == 4) {
				document.getElementById("FK_dataType").innerHTML = req.responseText;
				document.getElementById("FK_field").innerHTML = "<input id='FK_fieldValue' type='text' />";
				document.getElementById("FK_createButton").innerHTML = "<input type='button' value='Create Key'  onclick='showKey()' />";

			}
		};

		var query = "?entity=" + entity + "&activeAttribute=" + attribute;
		var url = "loadAttributeTypes" + query;

		req.open("GET", url, true);
		req.send(null);

	}

	function showKey() {
		var dbSuffix = "_db";
		var tablePreffix = "tbl_";
		var FKdomain = document.getElementById("FK_domain").value;
		var FKentity = document.getElementById("entity").value;
		var FKattribute = document.getElementById("activeAttribute").value;
		var FKtype = document.getElementById("attributeType").value;
		document.getElementById("FK_fieldValue").value = FKdomain + dbSuffix
				+ "." + tablePreffix + FKentity + "." + FKattribute + "."
				+ FKtype;

	}


	function addOptions(id){
  alert(id);
 document.getElementsByName("custom"+id).value= "lizo";
  
  
		}
</script>
<style type="text/css">
body {
	width: 100%;
}

#loggedUser {
	width: 350px;
	height: 10px;
	bottom: 0;
	float: right;
	color: red;
}

#head {
	background-color: lightgrey;
	height: 80px;
	width: 80%;
	margin-left: auto;
	margin-right: auto;
	border-bottom: 2px solid blue;
	position: relative;
	text-align: center;
}
</style>
</head>
 <%@ include file="header.jsp"%>  

	<table>
		<tr>
			<td>Available Domains</td>
			<td><select id="domainFound" name="domainFound"
				onchange="loadEntities()">
					<option value="">Please Select</option>
					<c:forEach var="domain" items="${domains}">
						<br />
						<option value="${domain}">${domain}</option>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td colspan="2"><div id="entitiesFound"></div></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><div id="newEntityButton"></div></td>
			<td><div id="entityOptions"></div></td>
		</tr>
	</table>

	<div id="mainHolder"></div>




</body>
</html>