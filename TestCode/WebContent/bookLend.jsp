<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
<script>
  $(function() {
	  $( "#datepicker" ).datepicker();
	  $("#datepickerreturn").datepicker();
      
  });
  </script>
<title>Book Lend</title>
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
				<h3 style="color:green;"><%=request.getAttribute("successMessage") %></h3>
			<%}%>

<form action="LendBookController" method="post">
<div style="font-size:16px; color: black;font-weight: bold;">Member Id:</div>
<div><input name="memberId" class="form-textbox" title="memberId" value="" size="30" maxlength="50" /></div><br>
<div style="font-size:16px; color: black;font-weight: bold;">Book Code:</div>
<div><input name="bookcode" class="form-textbox" title="bookcode" value="" size="30" maxlength="50" /></div><br>
<div style="font-size:16px; color: black;font-weight: bold;">Date Of Issue:</div>
<div><input name="dateofissue" type="text" class="form-textbox" title="dateofissue" id="datepicker" /></div><br>
<div style="font-size:16px; color: black;font-weight: bold;">Date Of Return:</div>
<div><input name="dateofreturn" type="text" class="form-textbox" title="dateofreturn" id="datepickerreturn"/></div><br>

<br>
<input style="margin-left:100px;" type="submit" value="Lend" />
</form>


</center>
</div>
</body>
</html>
