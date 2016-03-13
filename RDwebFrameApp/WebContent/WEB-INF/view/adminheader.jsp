<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style type="text/css">
 #menu {
    list-style:none;
    width:940px;
    margin:30px auto 0px auto;
    height:43px;
    padding:0px 20px 0px 20px;
 
    /* Rounded Corners */
     
    -moz-border-radius: 10px;
    -webkit-border-radius: 10px;
    border-radius: 10px;
 
    /* Background color and gradients */
     
    background: #014464;
    background: -moz-linear-gradient(top, #0272a7, #013953);
    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#0272a7), to(#013953));
     
    /* Borders */
     
    border: 1px solid #002232;
 
    -moz-box-shadow:inset 0px 0px 1px #edf9ff;
    -webkit-box-shadow:inset 0px 0px 1px #edf9ff;
    box-shadow:inset 0px 0px 1px #edf9ff;
}
 
#menu li {
    float:left;
    display:block;
    text-align:center;
    position:relative;
    padding: 4px 10px 4px 10px;
    margin-right:30px;
    margin-top:7px;
    border:none;
}
 
#menu li:hover {
    border: 1px solid #777777;
    padding: 4px 9px 4px 9px;
     
    /* Background color and gradients */
     
    background: #F4F4F4;
    background: -moz-linear-gradient(top, #F4F4F4, #EEEEEE);
    background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#F4F4F4), to(#EEEEEE));
     
    /* Rounded corners */
     
    -moz-border-radius: 5px 5px 0px 0px;
    -webkit-border-radius: 5px 5px 0px 0px;
    border-radius: 5px 5px 0px 0px;
}
 
#menu li a {
    font-family:Arial, Helvetica, sans-serif;
    font-size:14px; 
    color: #EEEEEE;
    display:block;
    outline:0;
    text-decoration:none;
    text-shadow: 1px 1px 1px #000;
}
 
#menu li:hover a {
    color:#161616;
    text-shadow: 1px 1px 1px #FFFFFF;
}
#menu li .drop {
    padding-right:21px;
    background:url("img/drop.png") no-repeat right 8px;
}
#menu li:hover .drop {
    background:url("img/drop.png") no-repeat right 7px;
}
 </style>
</head>

<body>
<div id="nav">
	<ul id="menu">
		<li ><a href="/">Home</a></li>
		<li ><a href="createdomainrequest">Create Domain</a></li>
		<li ><a href="newEntity">Create Entity</a></li>
		<li ><a href="viewcontentrequest">Show Content</a></li>
		<li ><a href="update">Add Content</a></li>
		<li ><a href="entityrelation">Association</a></li>
		<li ><a href="newpostrequest">Post Feed</a></li>
		</ul>

</div>
 
</body>
</html>