<%@page import="java.util.Date"%>
<%@page import="com.custom.model.Members"%>
<%@page import="java.util.List"%>
<%@page import="com.custom.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
<title>Member List</title>
</head>
<body>
<a href="home.jsp" style="color:brown;">Home</a>
<a href="logout.jsp" style="font-size: 18px;float:right;">Logout</a>
<div id="leftcolumn" style="float: left; width: 20%;">
	
	<%@include file="sidebar.jsp" %>
	</div>
	<div  id="centrecolumn" style="margin: 0 25%;padding-top: 100px; padding-left: 100px;">
<center>
<h1>MEMBER LIST</h1>
<table>
             <thead>
                 <tr>
                     <th>ID</th>
                     <th>Name</th>
                     <th>Address</th>
                     <th>MailId</th>
                     <th>PhoneNumber</th>     
                     <th>Member Type</th>  
                     <th>Issue Date</th>      
                     <th>Expiry Date</th>             
                 </tr>
             </thead>
             <tbody>
                 <%
                 MemberService memberListService = new MemberService();
                 List<Members> list = memberListService.getListofMembers();
                     for (Members m : list) {
                 %>
                 <tr>
                     <td><%=m.getMemberId()%></td>
                     <td><%=m.getMemberName()%></td>
                     <td><%=m.getMemberAddress()%></td>
                     <td><%=m.getMemberMailId()%></td>
                     <td><%=m.getMemberPhone()%></td>
                     <td><%=m.getMemberType()%></td>
                     <td><%=m.getDateOfIssue()%></td>
                     <td><%=m.getDateOfExpiry()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    

</center>
</div>
</body>
</html>