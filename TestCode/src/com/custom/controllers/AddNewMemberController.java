package com.custom.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.custom.model.Members;
import com.custom.service.MemberService;

public class AddNewMemberController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	public AddNewMemberController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
		String membername=request.getParameter("membername");
		String memberaddress=request.getParameter("memberaddress");
		String phonenumber=request.getParameter("phonenumber");
		String mailid=request.getParameter("mailid");
		String membertype = request.getParameter("membertype");

		 RequestDispatcher rd = null;
		 
		 MemberService memberService=new MemberService();
		
		String result=memberService.addNewMember( membername, memberaddress, phonenumber, mailid, membertype);
		
		
		if (result.equals("success")) {
			request.setAttribute("successMessage", "New Member Added Successfully!!!!");
			rd = request.getRequestDispatcher("/addnewMember.jsp");
			
			
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
