<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript">
	function getByUsername() {

		var search_str = document.getElementById("search_name").value;
		var optns = document.getElementById("options");
		var req = new XMLHttpRequest();

		req.onreadystatechange = function() {
			if (req.readyState == 4) {

				if (req.status == 200) {

					var ob = JSON.parse(req.responseText);
					while (optns.options.length) {
						optns.remove(0);
					}
					for (x = 0; x < ob.length; x++) {
						var opt = document.createElement("option");
						opt.appendChild(document.createTextNode(ob[x].last_name
								+ " " + ob[x].first_name));
						opt.value = ob[x].last_name;
						optns.appendChild(opt);
					}

				}
			}

		};

		var query = "?search_name=" + search_str;
		req.open("GET", "getUserByUsername" + query, true);
		req.send(null);

	}
</script>

<style type="text/css">

</style>
<link rel="stylesheet" type="text/css" href="<c:url value ="/resources/css/formtags.css"/>" />
</head>
<body>
	<form action="migrateUser">
		<table>
			<tr>
				<td><input type="text" id="search_name" name="search_name"
					onchange="getByUsername()" /></td>
				<td><select name="full_name" id="options"
					onclick="getByUsername()">
						<option>Please Select</option>
				</select></td>
				<td><input class="button" type="submit" value="Verify Records" /></td>
			</tr>
		</table>
	</form>


</body>
</html>