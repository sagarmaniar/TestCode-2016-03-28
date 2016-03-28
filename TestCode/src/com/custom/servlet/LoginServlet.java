package com.custom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
        String name;
        String date;
        String time;
        String guest;
        String address;
        String discription;
 
        name=request.getParameter("name");
        date=request.getParameter("date");
        time=request.getParameter("time");
        guest=request.getParameter("guest");
        address=request.getParameter("address");
        discription=request.getParameter("discription");
        HttpSession session=request.getSession(true);
        System.out.println("all is ok");
        try {
               System.out.println("name"+name);
               System.out.println("date"+date);
            } catch (Exception e) {
 
                e.printStackTrace();
            }
	}
}
