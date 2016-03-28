package com.custom.service;

/* JDBC_Connection_Demo.java */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.custom.tag.TestTagCode;
 
public class Condb
{
  /* static block is executed when a class is loaded into memory 
   * this block loads MySQL's JDBC driver
   */
//  static
//  {
//    try
//    {
//      // loads com.mysql.jdbc.Driver into memory
//      Class.forName("com.mysql.jdbc.Driver");
//    } 
//    catch (ClassNotFoundException cnf) 
//    {
//      System.out.println("Driver could not be loaded: " + cnf);
//    }
//  }
	
	

 
 
  public static void main(String[] args)
  {
	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		Date datenew = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 180);
		dateFormat.format(cal.getTime());
	   
	
		System.out.println("date "+date);
		System.out.println("date format>>>  "+dateFormat.format(date));
		System.out.println("calendar date format>>>  "+dateFormat.format(cal.getTime()));
	  
  }
	 /* public void TagFunct(String msg)
	  {
			System.out.println("In DBConnect.java>>Called from JspTag>>"+msg);
			
	  
	  
	  System.out.println("Entered dbconnect main>>>>");
	  try
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
    String dbPwd = "mysqladmin";
    Connection conn;
    ResultSet rs;
    System.out.println("REached till here");
    String queryString = "SELECT username FROM logintbl";
 
    try
    {
      conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
      Statement stmt = conn.createStatement();
 
      // INSERT A RECORD
//      stmt.executeUpdate("INSERT INTO logintbl (username) VALUES (\"devu\") ");
      
      stmt.executeUpdate("INSERT INTO logintbl " +
      "VALUES ('trvy', 'yest')");
 
      // SELECT ALL RECORDS FROM EXPTABLE
      rs = stmt.executeQuery(queryString);
 
      System.out.println("ID \tNAME");
      System.out.println("============");
      while(rs.next())
      {
    	  System.out.print(rs.getString("username"));
//        System.out.print(rs.getInt("REGISTERID"));
        System.out.println();
      }
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
  }*/
} //JDBC_Connection_Demo ends here
