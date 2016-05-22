<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        <div class="container">
            <form action="create">
                    <input type="text"  name="names"/>
                    <input type="text"  name="surname"/>
                    <input type="text"  name="nurse"/>
                     <input type="text"  name="idNumber"/>
                    <input type="submit" value="Create">
            </form>
        </div>
</body>
</html>