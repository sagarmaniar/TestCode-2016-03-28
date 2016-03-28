package com.custom.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.custom.model.Books;
import com.custom.model.Members;

public class MemberService {

	/* Get Member List method*/
		public List<Members> getListofMembers(){

//		 try
//		    {
//		      // loads com.mysql.jdbc.Driver into memory
//		      Class.forName("com.mysql.jdbc.Driver");
//		    } 
//		    catch (ClassNotFoundException cnf) 
//		    {
//		      System.out.println("Driver could not be loaded: " + cnf);
//		    }
//		  
//		 String connectionUrl = "jdbc:mysql://localhost:3306/my_schema";
//		 String dbUser = "root";
//		 String dbPwd = "mysqladmin";
		 Connection conn;
		 String queryString = "SELECT * FROM members";
		 ResultSet rs;
		 List<Members> list = new ArrayList<Members>();
		 ConnectToDBService connDb=new ConnectToDBService();

	try
	{
		
			conn= connDb.DBConnect();
//	conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
	Statement stmt = conn.createStatement();

	rs = stmt.executeQuery(queryString);

	
	int i=1;
	while (rs.next()) {    
	Members members = new Members();

	members.setMemberId(rs.getInt("memberId"));
	members.setMemberName(rs.getString("memberName"));
	members.setMemberAddress(rs.getString("memberAddress"));
	members.setMemberMailId(rs.getString("memberMailId"));
	members.setMemberPhone(rs.getString("memberPhone"));
	members.setMemberType(rs.getString("memberType"));
	members.setDateOfIssue(rs.getDate("dateOfIssue"));
	members.setDateOfExpiry(rs.getDate("dateOfExpiry"));
	
	list.add(members);
	System.out.println("Book List"+i+"list is"+list.get(0).getMemberId());
	i++;
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
	return list;
	}
	
		/* Add a new Member method*/
		public String addNewMember(String membername,String memberaddress,String phonenumber,String mailid,String membertype){

//			 try
//			    {
//			      // loads com.mysql.jdbc.Driver into memory
//			      Class.forName("com.mysql.jdbc.Driver");
//			    } 
//			    catch (ClassNotFoundException cnf) 
//			    {
//			      System.out.println("Driver could not be loaded: " + cnf);
//			    }
//			  
//			 String connectionUrl = "jdbc:mysql://localhost:3306/my_schema";
//			 String dbUser = "root";
//			 String dbPwd = "mysqladmin";
			 Connection conn;
			 String queryString = "INSERT INTO MEMBERS (MEMBERNAME,MEMBERADDRESS,MEMBERMAILID,MEMBERPHONE,MEMBERTYPE,DATEOFISSUE,DATEOFEXPIRY) "+ " VALUES (?,?,?,?,?,?,?)";
			 ConnectToDBService connDb=new ConnectToDBService();

		try
		{
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, 180);
				dateFormat.format(cal.getTime());
				
				conn= connDb.DBConnect();
//		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		
	
		PreparedStatement preparedStmt = conn.prepareStatement(queryString);
		   preparedStmt.setString(1, membername);
		   preparedStmt.setString(2, memberaddress);
		   preparedStmt.setString(3, phonenumber);
		   preparedStmt.setString(4, mailid);
		   preparedStmt.setString(5, membertype);
		   preparedStmt.setString(6, dateFormat.format(date));
		   
		   preparedStmt.setString(7, dateFormat.format(cal.getTime()));
		   
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
		
}
