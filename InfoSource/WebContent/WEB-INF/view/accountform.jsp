<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<b>Home</b>

	<div id="wrapper">
		<div id="Header"></div>
		<div id="main">
			<form action="process" method="get">
				<label for="firstname">First Name</label> <input type="text"
					name="firstname" /><br /> <label for="lastname">Last Name</label>
				<input type="text" name="lastname" /><br /> <label for="username">User
					Name</label> <input type="text" name="username" /><br /> <label
					for="idNumber">Id Number</label> <input type="text" name="idNumber" /><br />
				<label for="gender">Gender</label>
				 <select name="gender">
				 <option value="">Select</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
				</select><br/>
				 <label for="cell">Cell number</label>
				  <input type="text"
					name="cell" /><br /> <label for="email">Email Address</label> <input
					type="text" name="email" /><br /> <label for="password">Password</label>
				<input type="text" name="password" /><br />
<input type="submit"  value="Create"/>
			</form>
		</div>
	</div>
</body>
</html>