package com.custom.service;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LendReturnService {
	
public String LendBook(int memberId, String bookId,String dateofissue, String dateofreturn){
	
	
	ConnectToDBService connDb=new ConnectToDBService();
	 Connection conn;
	 String queryString = "INSERT INTO LENDRETURNBOOK (BOOKID,MEMBERID,DATEOFISSUE,DATEOFRETURN) "+ " VALUES (?, ?, ?, ?)";
	
	 try{
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 
		 conn= connDb.DBConnect();
		 
		   PreparedStatement preparedStmt = conn.prepareStatement(queryString);
		   preparedStmt.setString(1, bookId);
		   preparedStmt.setInt(2, memberId);
		   preparedStmt.setString(3, dateofissue);
		   preparedStmt.setString(4, dateofreturn);
		   preparedStmt.execute();
		   PreparedStatement ps = conn.prepareStatement(
			"UPDATE BOOKS SET bookavailability = ? WHERE bookid = ?");
				  ps.setString(1,"N");
				  ps.setString(2,bookId);

				ps.executeUpdate();
				
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

public String ReturnBook(int memberId, String bookId,String actualreturn){
	
	
	ConnectToDBService connDb=new ConnectToDBService();
	 Connection conn;
	 String queryString = "UPDATE LENDRETURNBOOK SET ACTUALRETURNDATE=? , LENDRETURN = ? WHERE bookid = ? and memberId=?";
	
	 try{
		 conn= connDb.DBConnect();
		 PreparedStatement preparedStmt = conn.prepareStatement(queryString);
		   preparedStmt.setString(1, actualreturn);
		   preparedStmt.setString(2, "R");
		   preparedStmt.setString(3, bookId);
		   preparedStmt.setInt(4,memberId);
		   preparedStmt.execute();
		 
		/* PreparedStatement psreturn = conn.prepareStatement(
					"UPDATE LENDBOOK SET LENDRETURN = ? WHERE bookid = ? and memberId=?");
		 System.out.println("bookid>>>"+bookId);
		 System.out.println("memberId>>>"+memberId);
		 psreturn.setString(1,"R");
		 psreturn.setString(2,bookId);
		 psreturn.setInt(3,memberId);
		 psreturn.executeUpdate();
		 */

		
		 
		 
		 PreparedStatement ps = conn.prepareStatement(
					"UPDATE BOOKS SET bookavailability = ? WHERE bookid = ?");
						  ps.setString(1,"Y");
						  ps.setString(2,bookId);

						ps.executeUpdate();
		 conn= connDb.DBConnect();
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
