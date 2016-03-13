<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
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
			<h2>Successfully Created</h2>
<table border="1">
	<tr>
		<td>Domain Creator</td>
		<td>${domain.creator}</td>
	</tr>
	<tr>
		<td>Domain Name</td>
		<td>${domain.domainName}</td>
	</tr>
	<tr>
		<td>Domain Organization</td>
		<td>${domain.orgName}</td>
	</tr>
	<tr>
		<td>Domain Category</td>
		<td>${domain.category}</td>
	</tr>
	<tr>
		<td>Contact Details</td>
		<td>${domain.contactDetails}</td>
	</tr>
	<tr>
		<td>Description</td>
		<td>${domain.description}</td>
	</tr>

	<tr>
		<td id="action" colspan="2" align="center"><a
			href="editdomain?domainId=${domain.domainId}">Edit</a> <a
			href="destroydomain?domainId=${domain.domainId}">Destroy</a></td>
	</tr>
</table>
			</div>
			<div id="right"></div>

		</div>
<div id="footer"></div>
	</div>


</body>
</html>