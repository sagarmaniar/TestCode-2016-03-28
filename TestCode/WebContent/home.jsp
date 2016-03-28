<%@page import="java.util.Date"%>
<%@page import="com.custom.service.BookService"%>
<%@page import="com.custom.model.User"%>
<%@page import="com.custom.model.Books"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>

<title>HOME PAGE</title>
</head>
<body>

<h1>	Welcome ${requestScope['user'].username}.

 </h1>
 
           <br>  <%=new Date()%></br>
             <%-- <%
                 User user = (User) session.getAttribute("user");
             %> --%>   
             <a href="logout.jsp" style="font-size: 18px;float:right;">Logout</a>
	<div id="leftcolumn" style="float: left; width: 20%;">
	
	<%@include file="sidebar.jsp" %>
	</div>
	
	<div  id="centrecolumn" style="margin: 0 25%;">
             <h2 style="margin-top:50px;">Search by:</h2>
	<form action="LookUpController" method="post"> 
 		<div style="margin-left:100px;margin-top:80px;" >
			<input name="bookName" type="text" class="form-textbox" title="bookName" value="" size="30" maxlength="48" />
			<input type="submit" style="margin-left:10px;" value="BookName" />
			<a href="home.jsp" class="buttonreset">Reset</a>
		</div>  
		
		<br>
		<br>

	</form>
			<% if(request.getAttribute("errorMessage")!=null ){%>
				<h2><%=request.getAttribute("errorMessage") %></h2>
			<%}%>
			<%
			
			if(request.getAttribute("list")!=null){ %>
			<table>
			<thead>
                 <tr>
                     <th>ID</th>
                     <th>Title</th>
                     <th>Author</th>
                     <th>Availability</th>
                     <th>Price</th>                
                 </tr>
             </thead>
             <tbody>
                <%  
                 
                ArrayList<Books> list = (ArrayList<Books>) request.getAttribute("list");
                     for (Books b : list) {
                    	 %>
                 <tr>
                     <td><%=b.getBookId()%></td>
                     <td><%=b.getBookTitle()%></td>
                     <td><%=b.getBookAuthor()%></td>
                     <td><%=b.getAvailability()%></td>
                     <td><%=b.getBookPrice()%></td>
                 </tr>
                 <%}}%>
             <tbody>
			</table>
			     </div>
 
</body>
</html>