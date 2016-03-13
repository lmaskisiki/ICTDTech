<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function setCustom() {

	}

	function AddValue() {
		var values = document.getElementById("optionValues").value;
		var newValue = document.getElementById("optionValue").value;
		alert("helllllo");
		if (values != "") {
			values = values + ", \n" + newValue;
		} else {
			values = values + newValue;
		}
		document.getElementById("optionValues").value = values.toString();

	}

	function saveValues(id) {
		alert("in")
		var values = document.getElementById("optionValues").value;
		alert(values);
		opener.document.getElementById(custom+id).value=values;
		self.close();
	}
</script>


</head>
<body>
	<div>
		<form action="" method="post" name="CustAttForm">

			<table>
				<tr>
					<td colspan="2"><textarea rows="5" cols="20" id="optionValues"
							name="optionValues"></textarea></td>
				</tr>
				<tr>
					<td><input type="text" name="optionValue" id="optionValue" />
						<input type="button" value="Add" onclick="AddValue()" /></td>
				</tr>
				<tr>
					<td><input type="button" value="Done" onclick="saveValues()" />
						<input type="button" value="Clear" /></td>
				</tr>
			</table>



		</form>
	</div>
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