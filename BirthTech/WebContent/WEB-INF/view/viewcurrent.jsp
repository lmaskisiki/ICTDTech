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
</head>
<body>
	<div id="container">
		<div id="nav">
			<ul class="nav nav-tabs">
				<li><a href="martenal/getall">Find All</a></li>
				<li><a href="maternal/search">Search</a></li>
				<li><a href="martenal/new">Create New</a></li>
				<li><a href="martenal/getall">Update</a></li>
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
							<td>${maternal.idnumber}</td>
							<td>${maternal.names}</td>
							<td>${maternal.surname}</td>
							<td>${maternalt.nurse}</td>
							<td>${maternal.registration}</td>
							<td><input class="btn btn-primary" type="button"
								value="Show" onclick="showCheckupform()" /> <input
								class="btn btn-primary" type="button" value="Hide"
								onclick="showLabourform()" /></td>

						</tr>

					</tbody>
				</table>
			</div>
			<div class="panel-body">
				<div style="float: left; margin: 4px; padding: 6px">



					<div id="formcheck">

						<form action="/BirthTech/checkup/add" method="get" id="addCheckup"
							style="display: none;">
							<input type="hidden" name="martenalId" value="${maternal.mid}"
								readonly="readonly" />
							<table>

								<tr>
									<td>Nurse</td>
									<td><input type="text" name="nurse" /></td>
								</tr>

								<tr>
									<td>Place</td>
									<td><input type="text" name="place" /></td>
								</tr>
								<tr>
									<td>Comments</td>
									<td><textarea rows="5" cols="20" name="comments">  </textarea>
									</td>
								</tr>
								<tr>
									<td><input type="submit" /></td>
								</tr>
							</table>
						</form>
						<form action="blaa" id="addLabour" style="display: none">
							<table>
								<tr>
									<td>Names</td>
									<td><input type="text" name="names" /></td>
								</tr>
								<tr>
									<td>Surname</td>
									<td><input type="text" name="surname" /></td>
								</tr>
								<tr>
									<td>Gender</td>
									<td><input type="text" name="gender" /></td>
								</tr>
								<tr>
									<td><input type="hidden" name="martenalId"
										value="${maternal.mid}" /></td>
								</tr>
								<tr>
									<td><input type="submit" /></td>
								</tr>
							</table>
						</form>

					</div>
				</div>

				<div style="float: left; height: 300px; overflow: scroll; margin: 4px; padding: 6px">
					<table class="table table-condensed">
						<thead>
							<tr>
								<th>Checkup Id</th>
								<th>Nurse</th>
								<th>Place</th>
								<th>Comments</th>
								<th>Delivered</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${checkup}" var="check">
								<tr>
									<td>${check.checkupId}</td>
									<td>${check.nurse }</td>
									<td>${check.place }</td>
									<td>${check.comments }</td>
									<td>${check.delivered }</td>
								</tr>
							</c:forEach>


						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
	<script src="/BirthTech/resources/bootstrap/js/jquery-2.1.1.min.js"></script>
	<script src="/BirthTech/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>