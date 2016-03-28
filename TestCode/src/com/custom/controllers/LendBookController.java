package com.custom.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.ParserBasicInformation;

import com.custom.service.LendReturnService;

public class LendBookController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	public LendBookController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 try {
		String memberId=request.getParameter("memberId");	
		String bookcode=request.getParameter("bookcode");
		String dateOfIssue=request.getParameter("dateofissue");
		String dateOfReturn=request.getParameter("dateofreturn");
		
		System.out.println("Date Of Issue in LendController>>>>"+dateOfIssue);
		System.out.println("Date Of Return in LendController>>>>"+dateOfReturn);
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		RequestDispatcher rd = null;
		
		 int memId=Integer.parseInt(memberId);
		
		LendReturnService lrservice=new LendReturnService();
		String result=lrservice.LendBook(memId, bookcode, dateOfIssue, dateOfReturn);
		 if (result.equals("success")) {
				rd = request.getRequestDispatcher("/bookLend.jsp");
				request.setAttribute("successMessage", "Book Lend Successfully!!!!!");
				//User user = new User(username, password);
				//request.setAttribute("user", user);
			} else {
				rd = request.getRequestDispatcher("/error.jsp");
			}
			rd.forward(request, response);
		 }
		 
	 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
