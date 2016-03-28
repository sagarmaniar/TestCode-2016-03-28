package com.custom.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;


public class ConnectToDBService {
	/*@Resource(lookup = "jdbc/cleardb")

	private DataSource myDataSource;*/
	
	public Connection DBConnect(){
		
		
		
	 try
	    {
	      // loads com.mysql.jdbc.Driver into memory
	      Class.forName("com.mysql.jdbc.Driver");
	    } 
	    catch (ClassNotFoundException cnf) 
	    {
	      System.out.println("Driver could not be loaded: " + cnf);
	    }
	  
	 String connectionUrl = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_0819f09401638b8";
	
		 
		
	 String dbUser = "ba074d36fd7992";
	 String dbPwd = "5ffa6919";
	
	 Connection conn;
	 try{
		 //Connection conn = myDataSource.getConnection();
	 conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	 return conn;

	 }
	 catch(SQLException exp){
		 System.out.println("SQL Exception thrown: " + exp);
		 return null;

	 }
}
	
}