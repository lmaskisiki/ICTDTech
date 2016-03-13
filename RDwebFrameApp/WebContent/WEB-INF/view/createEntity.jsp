<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function setCustom(custom) {
		//alert(custom);
		document.getElementById("CustomField").value = custom;
		var divElement = document.getElementById("optionsDiv");
		divElement.style.display = "block";

	}
	function AddValue() {
		var values = document.getElementById("optionValues").value;
		var newValue = document.getElementById("optionValue").value;
		if (values != "") {
			values = values + ", \n" + newValue;
		} else {
			values = values + newValue;
		}
		document.getElementById("optionValues").value = values.toString();

	}
	function saveValues() {
		//	alert("in")
		var value = document.getElementById("CustomField").value;
		//alert(value);
		document.getElementById(value).value = document
				.getElementById("optionValues").value;
		var divElement = document.getElementById("optionsDiv");
		divElement.style.display = "none";
	}
	function addRows() {

		var table = document.getElementById("entityAttributes");
		var row = document.getElementById("entityRows");
		var clone = row.cloneNode(true);
		var c = document.getElementById("entityAttributes").rows.length;
		var att_number = document.getElementById("att_number");
		att_number.value = c - 1;
		table.appendChild(clone);

	}
	function setRowNumber() {
		var c = document.getElementById("entityAttributes").rows.length;
		alert(c - 1 + "returned");
		return c - 1;
	}
	function nullSet(checkbox) {
		var cell = checkbox.parentNode;
		var row = cell.parentNode;
		var cells = row.getElementsByTagName("td");
		var txField = cells[6].getElementsByTagName("input")[0];
		var value = txField.value;
		txField.value = value + checkbox.value + " ";

	}
</script>
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/layout.css"/>" />

</head>

<body>

	<div class="wrapper">
		<div id="header">
			<%@ include file="adminheader.jsp"%>
		</div>

		<div class="content">
			<div id="left"></div>
			<div id="main">

				<div>

					<div style="">

						<form action="newEntityData" method="post" name="newEntityData">


							<input type="hidden" id="att_number" name="att_number"
								value="${att_number}" /> <input type="hidden" name="domains"
								value="${domain}" />

							<table align="center" id="createenityTable">
								<tr>

									<td>Entity Name</td>
									<td colspan="4"><input type="text" name="entityName"
										size="12" /></td>
									<td>Domain</td>
									<td><select name="domain">
											<c:forEach items="${domains}" var="dom">
												<option value="${dom.domainName}">${dom.domainName}</option>
											</c:forEach>
									</select></td>
									<td>Access Type</td>

									<td><select name="accessType">
											<option>SELECT ONE</option>
											<c:forEach items="${accessTypes}" var="access">

												<option value="${access}">${access}</option>
											</c:forEach>
									</select></td>

								</tr>
							</table>
							<table border="1" id="entityAttributes" align="center">
								<tr>
									<th>Attribute Name</th>
									<th>Data Type</th>
									<th>Length</th>
									<th>Index</th>

									<th>NULL?</th>
									<th>AI</th>
									<th>Constraints</th>
									<th>Value Options</th>


								</tr>
								<tbody>

									<tr id="entityRows">
										<td><input type="text" name="attributes" /></td>
										<td><select name="types">
												<c:forEach var="type" items="${dtypes}">
													<option value="${type}">${type}</option>
												</c:forEach>

										</select></td>
										<td><input type="text" size="5" name="valueLength" /></td>
										<td><select name="columnAttrOne" onchange="nullSet(this)">
												<option value="">None</option>
												<option value="primary key">Primary Key</option>
												<option value="unique">Unique</option>
												<option value="index">Index</option>

										</select></td>
										<td align="center"><input type="checkbox"
											name="columnAttrTwo" value="NOT NULL"
											onchange="nullSet(this)" /></td>
										<td align="center"><input type="checkbox"
											name="columnAttrThree" value="AUTO_INCREMENT"
											onchange="nullSet(this)" /></td>

										<td><input type="text"  name="constraints"
										 /></td>


										<td><input type="text" id="CustomField${item}"
											name="CustomField${item}" size="30" /></td>
									</tr>
								</tbody>

							</table>
							<table align="center">
								<tr>

									<td><input type="button" value="Add Row"
										onclick="addRows()" /></td>
									<td><input type="button" value="Remove Row" /></td>

								</tr>
							</table>

							<table align="center">
								<tr>
									<td colspan="4"><input type="submit" value="Create"
										size="25" /></td>
								</tr>
							</table>
						</form>
					</div>
					<div id="optionsDiv" style="display: none;">
						<form action="" method="post" name="CustAttForm">
							<input type="hidden" id="CustomField" size="10" />
							<table>
								<tr>
									<td colspan="2"><textarea rows="4" cols="21" readonly
											id="optionValues" name="optionValues"></textarea></td>
								</tr>
								<tr>
									<td><input type="text" name="optionValue" id="optionValue" />


										<input type="button" value="Add" onclick="AddValue()" /></td>
								</tr>
								<tr>
									<td><input type="button" value="Done"
										onclick="saveValues()" /> <input type="button" value="Clear" /></td>
								</tr>
							</table>
						</form>
					</div>

				</div>

			</div>
			<div id="right"></div>

		</div>
		<div id="footer"></div>
	</div>


</body>
</html>