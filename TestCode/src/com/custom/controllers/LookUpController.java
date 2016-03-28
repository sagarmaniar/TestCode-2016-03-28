package com.custom.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.custom.model.Authenticator;
import com.custom.model.Books;
import com.custom.model.User;
import com.custom.service.BookService;

public class LookUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LookUpController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		String bookName=request.getParameter("bookName");
		request.setAttribute("bool", false);
		
		
		RequestDispatcher rd = null;
BookService booksearch= new BookService();
List<Books> list = booksearch.searchBook(bookName);
		System.out.println("list size in lookupcontroller>>>>>"+list.size());
		if (list.size()==0) {
			 request.setAttribute("errorMessage", "No Results Found");
			 request.setAttribute("list", null);
			 rd = request.getRequestDispatcher("/home.jsp");
		
			
		} else {
			request.setAttribute("list", list);
			request.setAttribute("errorMessage", null);
			rd = request.getRequestDispatcher("/home.jsp");
		}
		rd.forward(request, response);
	}

}
