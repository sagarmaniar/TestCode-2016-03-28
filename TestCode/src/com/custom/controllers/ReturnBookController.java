package com.custom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.custom.service.LendReturnService;

public class ReturnBookController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	public ReturnBookController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 try {
		String memberId=request.getParameter("memberId");	
		String bookcode=request.getParameter("bookcode");
		String actualdate=request.getParameter("dateofreturn");
		RequestDispatcher rd = null;
		
		 int memId=Integer.parseInt(memberId);

		 LendReturnService lrservice=new LendReturnService();
	String result=lrservice.ReturnBook(memId, bookcode, actualdate);
	if (result.equals("success")) {
		rd = request.getRequestDispatcher("/bookReturn.jsp");
		request.setAttribute("successMessage", "Book Returned Successfully!!!!!");
		
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