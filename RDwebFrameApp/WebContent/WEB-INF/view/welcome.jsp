<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/RDwebFrameApp/resources/js/helpers.js" type="text/javascript"></script>
<script type="text/javascript">
	function laodEntities(object) {
		var parentCategory = document.getElementById(object);
		var xhttprequest = new XMLHttpRequest();
		xhttprequest.onreadystatechange = function() {
			if (xhttprequest.readyState == 4) {
				if (xhttprequest.status == 200) {
					var obj = JSON.parse(xhttprequest.responseText);
					while (parentCategory.firstChild) {
						parentCategory.removeChild(parentCategory.firstChild);
					}
					for (var x = 0; x < obj.length; x++) {
						var li = document.createElement("li");
						var a = document.createElement("a");
						a.setAttribute("href", "#");
						a.setAttribute("onclick", "loadData('" + obj[x] + "')");
						a.setAttribute("id", obj[x]);
						a.appendChild(document.createTextNode(obj[x]));
						li.setAttribute("id", "list" + obj[x]);
						li.appendChild(a);
						parentCategory.appendChild(li);
					}
				}
			}
		};
		var query = "?category=" + object;
		xhttprequest.open("GET", "getdomainbycategory" + query, true);
		xhttprequest.send(null);

	}

	function loadData(obj) {

		var dmain = obj;
		var domainNode = document.getElementById("list" + obj);

		if ((dmain != "") || (dmain != null)) {
			var xhttprequest = new XMLHttpRequest();
			xhttprequest.onreadystatechange = function() {
				if (xhttprequest.readyState == 4) {
					if (xhttprequest.status == 200) {
						var ents = JSON.parse(xhttprequest.responseText);
						var ul = document.createElement("ul");
						for (var x = 0; x < ents.length; x++) {
							var li = document.createElement("li");
							var a = document.createElement("a");
							a.setAttribute("href", "#");
							a.setAttribute("onclick", "getcontent('" + obj
									+ "','" + ents[x] + "')");
							a.setAttribute("id", obj[x]);
							a.appendChild(document.createTextNode(ents[x]));
							li.setAttribute("id", ents[x]);
							li.appendChild(a);
							ul.appendChild(li);
						}
						domainNode.appendChild(ul);

					}
				}

			};
			var query = "?domain= " + dmain;
			xhttprequest.open("GET", "getentities" + query, true);
			xhttprequest.send(null);
		}

	}

	function getcontent(obj, ent) {
		//web/viewconten
		var xhttprequest = new XMLHttpRequest();
		xhttprequest.onreadystatechange = function() {
			if (xhttprequest.readyState == 4) {
				if (xhttprequest.status == 200) {
					var jsonData = JSON.parse(xhttprequest.responseText);
					var data = jsonData.data;
					var keys = getKeys(data);
					presentData(keys, data);
				}
			}

		};
		var query = "?entity=" + ent;
		xhttprequest.open("GET", "getjsoncontent" + query, true);
		xhttprequest.send(null);

	}

	function getKeys(data) {
		var keys = [];
		var d = data[0];
		for (obj in d) {
			if (d.hasOwnProperty(obj)) {
				keys.push(obj);
			}
		}
		return keys;
	}

	function presentData(keys, data) {
		var contentHolder = document.getElementById("main");
		var table = document.createElement("table");
		var headerrow = document.createElement("tr");

		for (x = 0; x < keys.length; x++) {
			var th = document.createElement("th");
			th.appendChild(document.createTextNode(keys[x]));
			headerrow.appendChild(th);
		}
		for (x = 0; x < keys.length; x++) {
			var datarow = document.createElement("tr");
			var d = data[x];
			for (key in d) {
				if (d.hasOwnProperty(key)) {
					var td = document.createElement("td");
					td.appendChild(document.createTextNode(d[key]));
					datarow.appendChild(td);
				}

			}
			table.appendChild(datarow);
			table.insertBefore(headerrow, table.firstChild)
			while (contentHolder.firstChild) {
				contentHolder.removeChild(contentHolder.firstChild)
			}
			contentHolder.appendChild(table);
		}
	}
</script>

<style type="text/css">
.wrapper {
	color: black;
	background-color: highlight;
	width: 100%;
	min-height: 100%;
	position: absolute;
	border: 1px solid white;
}

#nav {
	width: 100%;
	height: 80px;
}

#nav #bar {
	width: 50%;
	margin: 0 auto;
}

#nav #bar li {
	float: right;
	list-style: none;
	margin: 5px;
}

#nav #bar li li {
	display: none;
}

#container {
	width: 100%;
}

#sidebar1 {
	width: 20%;
	float: left;
	border: 1px solid white;
	border-radius: 5px;
	overflow: auto;
	background-color: buttonface;
}

#main {
	width: 59%;
	min-height: 90%;
	float: left;
	/*background-color: buttonface;*/
	/*overflow: auto;*/
	display: block;
}

#sidebar2 {
	width: 20%;
	float: right;
	border: 1px solid white;
	border-radius: 5px;
	overflow: auto;
	background-color: buttonface;
}

#sidebar1 ul li {
	color: green;
	list-style: armenian;
	display: block;
	background-color: buttonface;
	margin: 4px;
}

#sidebar1  li a {
	text-decoration: none;
	height: 20px;
	color: black;
	background-color: white;
	border: 1px solid black;
	border-style: outset;
	border-radius: 5px;
	margin: padding 10px;
	display: block;
	text-align: justify;
}

#sidebar1  li a:HOVER {
	background-color: buttonface;
}

tfoot {
	font: small;
	color: blue;
}
</style>
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/table1.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value ="/resources/theme/css/menu.css"/>" />
</head>
<body>
	<div class="wrapper">
		<div id="nav">


			<ul id="menu">
				<li><a href="#">Account</a>
					<ul id="nav-drop">
						<li><a href="#">Login</a></li>
						<li><a href="#">Sign Up</a></li>
					</ul></li>
				<li><a href="#">About</a></li>
				<li><a href="#">Report Issues</a></li>
				<li><a href="web/admin">Domain</a></li>
			</ul>

		</div>

		<div id="container">
			<div id="sidebar1">
				<ul id="categoryList">
					<c:forEach items="${categories}" var="cat">
						<li><a href="#" onclick="laodEntities('${cat}')">${cat}</a>
							<ul id="${cat}">

							</ul></li>
					</c:forEach>
				</ul>
			</div>
			<div id="main">

				<c:forEach items="${feeds}" var="feed">
					<table>
						<thead>
							<tr>
								<td colspan="2">${feed.title}</td>
							</tr>
						</thead>
						<tbody>

							<tr>
								<td colspan="3">${feed.body}</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td>Post Date: ${feed.postDate }</td>
								<td>Author: ${feed.author}</td>
							</tr>
						</tfoot>
					</table>

					<br />

				</c:forEach>

			</div>
			<div id="sidebar2">
				<h2>Announcements</h2>
			</div>
		</div>

	</div>
</body>
</html>