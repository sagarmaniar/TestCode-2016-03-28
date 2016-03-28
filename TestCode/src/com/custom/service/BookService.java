package com.custom.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.custom.model.Books;

public class BookService 
{
	 
	public List<Books> getListofBooks(){

	/* try
	    {
	      // loads com.mysql.jdbc.Driver into memory
	      Class.forName("com.mysql.jdbc.Driver");
	    } 
	    catch (ClassNotFoundException cnf) 
	    {
	      System.out.println("Driver could not be loaded: " + cnf);
	    }
	  
	 String connectionUrl = "jdbc:mysql://localhost:3306/my_schema";
	 String dbUser = "root";
	 String dbPwd = "mysqladmin";*/
		ConnectToDBService connDb=new ConnectToDBService();
	 Connection conn;
	 String queryString = "SELECT * FROM books";
	 ResultSet rs;
	 List<Books> list = new ArrayList<Books>();

try
{
	conn= connDb.DBConnect();	
//conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
Statement stmt = conn.createStatement();

rs = stmt.executeQuery(queryString);

System.out.println("im in java standalone app");
int i=1;
while (rs.next()) {    
Books books = new Books();
books.setBookId(rs.getString("bookId"));
books.setBookTitle(rs.getString("bookTitle"));
books.setBookAuthor(rs.getString("bookAuthor"));
books.setBookPrice(rs.getDouble("bookPrice"));
books.setAvailability(rs.getString("bookAvailability"));
list.add(books);
System.out.println("Book List"+i+"list is"+list);
i++;
}

//while (rs.next()) {              
//    System.out.println("In while loop getting rs"+i+"and values>>"+rs.getRowId(i));
//    i++;
//    
//}
if (conn != null)
{
  conn.close();
  conn = null;
}
}
catch (SQLException sqle) 
{
  System.out.println("SQL Exception thrown: " + sqle);
  
}
return list;
}
	public String addNewBook(String bookname,String bookauthor,String bookcode,String bookprice){

		/* try
		    {
		      // loads com.mysql.jdbc.Driver into memory
		      Class.forName("com.mysql.jdbc.Driver");
		    } 
		    catch (ClassNotFoundException cnf) 
		    {
		      System.out.println("Driver could not be loaded: " + cnf);
		    }
		  
		 String connectionUrl = "jdbc:mysql://localhost:3306/my_schema";
		 String dbUser = "root";
		 String dbPwd = "mysqladmin";*/
		ConnectToDBService connDb=new ConnectToDBService();
		 Connection conn;
		 String queryString = "INSERT INTO BOOKS (BOOKID,BOOKTITLE,BOOKAUTHOR,BOOKPRICE) "+ " VALUES (?,?,?,?)";
		 ResultSet rs;
		 List<Books> list = new ArrayList<Books>();

	try
	{
		conn= connDb.DBConnect();	
	//conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	Statement stmt = conn.createStatement();
	Double bookpricedouble=Double.parseDouble(bookprice);

	PreparedStatement preparedStmt = conn.prepareStatement(queryString);
	   preparedStmt.setString(1, bookcode);
	   preparedStmt.setString(2, bookname.toUpperCase());
	   preparedStmt.setString(3, bookauthor.toUpperCase());
	   preparedStmt.setDouble(4, bookpricedouble);
	   preparedStmt.execute();
	   if (conn != null)
	   {
	     conn.close();
	     conn = null;
	   }
	   return "success";
	 }
	catch (SQLException sqle) 
	 {
	   System.out.println("SQL Exception thrown: " + sqle);
	   return "error";
	 }
	
	}
	
	public List<Books> searchBook(String bookname){

		/* try
		    {
		      // loads com.mysql.jdbc.Driver into memory
		      Class.forName("com.mysql.jdbc.Driver");
		    } 
		    catch (ClassNotFoundException cnf) 
		    {
		      System.out.println("Driver could not be loaded: " + cnf);
		    }
		  
		 String connectionUrl = "jdbc:mysql://localhost:3306/my_schema";
		 String dbUser = "root";
		 String dbPwd = "mysqladmin";*/
		ConnectToDBService connDb=new ConnectToDBService();
		 Connection conn;
		 String queryString = "SELECT * FROM BOOKS WHERE BOOKTITLE LIKE ?";
		 ResultSet rs;
		 List<Books> list = new ArrayList<Books>();

	try
	{
		conn= connDb.DBConnect();	
	//conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	PreparedStatement preparedStatement = conn.prepareStatement(queryString);
	preparedStatement.setString(1, "%" + bookname + "%");
	rs = preparedStatement.executeQuery();
	if(rs!=null){
		
		 int i=1;
		 while (rs.next()) {    
		 Books books = new Books();
		 books.setBookId(rs.getString("bookId"));
		 books.setBookTitle(rs.getString("bookTitle"));
		 books.setBookAuthor(rs.getString("bookAuthor"));
		 books.setBookPrice(rs.getDouble("bookPrice"));
		 books.setAvailability(rs.getString("bookAvailability"));
		 list.add(books);
		 System.out.println("Book List"+i+"list is"+list);
		 i++;
		 }
	}
	if (conn != null)
	{
	  conn.close();
	  conn = null;
	}
return list;
}
	catch (SQLException sqle) 
	 {
	   System.out.println("SQL Exception thrown: " + sqle);
	 
	 }
	 return list;
	}
	
}
