package com.custom.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.custom.model.User;
import com.custom.service.BookService;

public class AddNewBookController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	public AddNewBookController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 try {
		String bookname=request.getParameter("bookname");
		String bookauthor=request.getParameter("bookauthor");
		String bookcode=request.getParameter("bookcode");
		String bookprice=request.getParameter("bookprice");
		String dateofarrival = request.getParameter("dateofarrival");
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		 
			//Date dateresult = formater.parse(dateofarrival);
		
		  RequestDispatcher rd = null;
		  BookService bookService=new BookService();
		  String result=bookService.addNewBook(bookname,bookauthor,bookcode,bookprice);
		  if (result.equals("success")) {
				rd = request.getRequestDispatcher("/addNewBook.jsp");
				request.setAttribute("successMessage", "New Book Added Successfully!!!!!");
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
