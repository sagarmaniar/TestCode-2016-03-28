package com.custom.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class LoginService {
	
	public boolean Authenticate(String a, String b){
	 /*try
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
	 String queryString = "SELECT * FROM logintbl";
	 ResultSet rs;
 
 try
 {
	 
	conn= connDb.DBConnect();
	
  /* conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);*/
   Statement stmt = conn.createStatement();
   
   rs = stmt.executeQuery(queryString);

  
 while(rs.next())
 {
	 
	 String username=rs.getString("username");
	 String password=rs.getString("password");
	 System.out.print("Username inside rs while loop>>>"+username);
	 System.out.print("Password inside rs while  loop>>>"+password);
	 if(a.equalsIgnoreCase(username) && b.equals(password)){
		 System.out.println("username");
		 System.out.println("password");
		
		return true; 
	 }
 }
		 if (conn != null)
		 {
		   conn.close();
		   conn = null;
		 }
		 
	 
		 
	 
	 
 
 System.out.println("just before return false in service");
 return false;
 
 
 
}
	 catch (SQLException sqle) 
	 {
	   System.out.println("SQL Exception thrown: " + sqle);
	   return false;
	 }

	}
	


	public boolean UpdateUser(String name, String pwd){
/*	 try
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
	 String queryString = "INSERT INTO LOGINTBL (USERNAME,PASSWORD) "+ " VALUES (?, ?)";
            
	 ResultSet rs;
 
 try
 {
	 conn= connDb.DBConnect();
//   conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
  // Statement stmt = conn.createStatement();
   PreparedStatement preparedStmt = conn.prepareStatement(queryString);
   preparedStmt.setString(1, name);
   preparedStmt.setString(2, pwd);
   preparedStmt.execute();
   
   if (conn != null)
   {
     conn.close();
     conn = null;
   }
   return true;
 }

 catch (SQLException sqle) 
 {
   System.out.println("SQL Exception thrown: " + sqle);
   return false;
 }

}
}