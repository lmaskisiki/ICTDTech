<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Basic Bootstrap Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="/BirthTech/resources/bootstrap/css/bootstrap.min.css">
<!-- Optional Bootstrap theme -->
<link rel="stylesheet"
	href="/BirthTech/resources/bootstrap/css/bootstrap-theme.min.css">

<script type="text/javascript">
	function showCheckupform() {
		var el = document.getElementById("addCheckup");
		var elhide = document.getElementById("addLabour");
		if (el != null) {
			elhide.style.display = "none";
			el.style.display = "block";

		}
	}

	function showLabourform() {
		var el = document.getElementById("addLabour");
		var elhide = document.getElementById("addCheckup");
		if (el != null) {
			elhide.style.display = "none";
			el.style.display = "block";

		}
	} 	 
</script>
<style type="text/css">
#addcheckuptable {
	display: none;
 	margin: auto;
	background-color: buttonface;
}

table {
	margin: auto;;
}
</style>
</head>
<body>
	<div id="container">
		<div id="nav">
			<ul class="nav nav-tabs">
				<li><a href="http://localhost:8080/BirthTech/">Home</a></li>
				
			</ul>
		</div>


		<div class="panel panel-default">
			<div class="panel-heading">
				<table class="table table-condensed">
					<thead>
						<tr>
							<th>ID Number</th>
							<th>First Name(s)</th>
							<th>Last Name</th>
							<th>Nurse</th>
							<th>Registration Date</th>
							<th>Action Now</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${maternity.idnumber}</td>
							<td>${maternity.names}</td>
							<td>${maternity.surname}</td>
							<td>${maternity.nurse}</td>
							<td>${maternity.registration}</td>
							<td>
								<button class="btn btn-primary" id="showcheckups">Show
									Records</button>
								<button class="btn btn-primary" id="addcheckup">Add
									Record</button>
								<button class="btn btn-primary" id="addlabour">Register
									Birth</button>

							</td>

						</tr>

					</tbody>
				</table>
			</div>
			<div class="panel-body">
				<div style="float: left;">
					<form action="checkup/add" method="get">
						<input type="hidden" name="maternity" id="maternity"
							value="${maternity.idnumber}">

						<table class="table table-condensed" id="addcheckuptable">
							<tr>
								<td>Place</td>
								<td><input name="place" type="text" /></td>
							</tr>
							<tr>
								<td>Nurse</td>
								<td><input name="nurse" type="text" /></td>
							</tr>
							<tr>
								<td>Infection(s)</td>
								<td><input name="infection" type="text" /></td>
							</tr>

							<tr>
								<td>Weight</td>
								<td><input name="weight" type="text" /></td>
							</tr>
							<tr>
								<td>Temperature</td>
								<td><input name="temperature" type="text" /></td>
							</tr>
							<tr>
								<td>Medication</td>
								<td><input name="medication" type="text" /></td>
							</tr>
							<tr>
								<td>Weeks</td>
								<td><input name="weeks" type="text" /></td>
							</tr>
							<tr>
								<td>Delivery</td>
								<td><select id="deliverystatus" name="delivered" >
										<option value="no">Select</option>
										<option value="yes">YES</option>
										<option value="no">NO</option>
								</select></td>
							</tr>
							<tr>
								<td>Comments</td>
								<td><textarea name="comments" rows="4" cols="40"></textarea></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Create" /></td>
							</tr>
						</table>
					</form>
				</div>
				<div class="checkups" style="left: right; overflow: auto;"></div>
			</div>
		</div>


	</div>
	<script src="/BirthTech/resources/bootstrap/js/ajaxcalls.js"></script>
	<script src="/BirthTech/resources/bootstrap/js/jquery-1.12.4.min.js"></script>
	<script src="/BirthTech/resources/bootstrap/js/js.js"></script>
	<script src="/BirthTech/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>