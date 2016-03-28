<%@page import="java.util.Date"%>
<%@page import="com.custom.model.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.custom.service.BookService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css"/>
<title>List of Books</title>
</head>
<body>
<script src="table.js"></script>
<a href="home.jsp" style="color:brown;">Home</a>
<a href="logout.jsp" style="font-size: 18px;float:right;">Logout</a>
<div id="leftcolumn" style="float: left; width: 20%;">
	
	<%@include file="sidebar.jsp" %>
	</div>
	<div  id="centrecolumn" style="margin: 0 25%;padding-top: 100px; padding-left: 100px;">
<center>
<h1>BOOK LIST</h1>
<div><input name="bookname" type="text" class="form-textbox" title="bookname" value="" size="30" maxlength="50" onchange="validate()" /></div><br>
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
                 BookService bookListService = new BookService();
                 List<Books> list = bookListService.getListofBooks();
                     for (Books b : list) {
                 %>
                 <tr>
                     <td><%=b.getBookId()%></td>
                     <td><%=b.getBookTitle()%></td>
                     <td><%=b.getBookAuthor()%></td>
                     <td><%=b.getAvailability()%></td>
                     <td><%=b.getBookPrice()%></td>
                 </tr>
                 <%}%>
             <tbody>
         </table>    

</center>
</div>
</body>
</html>
