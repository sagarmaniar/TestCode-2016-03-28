<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
<title>Add New Member</title>
</head>
<body>
<a href="home.jsp" style="color:brown;">Home</a>
<a href="logout.jsp" style="font-size: 18px;float:right;">Logout</a>
<div id="leftcolumn" style="float: left; width: 20%;">
	
	<%@include file="sidebar.jsp" %>
	</div>
	<div  id="centrecolumn" style="margin: 0 25%;padding-top: 100px; padding-left: 100px;">
	<center>
	<% if(request.getAttribute("successMessage")!=null ){%>
				<h2 style="color:green;"><%=request.getAttribute("successMessage") %></h2>
			<%}%>
<form action="AddNewMemberController" method="post">
<div style="font-size:16px; color: black;font-weight: bold;">Member Name:</div>
<div><input name="membername" class="form-textbox" title="membername" value="" size="30" maxlength="50" /></div><br>
<div style="font-size:16px; color: black;font-weight: bold;">Member Address:</div>
<div><input name="memberaddress" class="form-textbox" title="memberaddress" value="" size="30" maxlength="50" /></div><br>
<div style="font-size:16px; color: black;font-weight: bold;">Phone Number:</div>
<div><input name="phonenumber" class="form-textbox" title="phonenumber" value="" size="30" maxlength="10" /></div><br>
<div style="font-size:16px; color: black;font-weight: bold;">Mail Id:</div>
<div><input name="mailid" class="form-textbox" title="mailid" value="" size="30" maxlength="50" /></div><br>
<div style="font-size:16px; color: black;font-weight: bold;">Member Type(T/P):</div>
<div><input name="membertype" type="text" class="form-textbox" title="membertype" value="" size="30" maxlength="1" /> 

</div><br>
<input style="margin-left:100px;" type="submit" value="Add New Member" />
</form>

 
</center>
</div>

</body>
</html>
