package com.custom.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.custom.model.Authenticator;
import com.custom.model.NewUserLogin;
import com.custom.model.User;

public class NewUserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewUserLoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username in NewController>>>> "+username);
		RequestDispatcher rd = null;

		NewUserLogin newUser = new NewUserLogin();
		
		String result = newUser.NewLogin(username, password);
		if (result.equals("success")) {
			rd = request.getRequestDispatcher("/newUserSuccess.jsp");
			User user = new User(username, password);
			request.setAttribute("user", user);
		} else {
			rd = request.getRequestDispatcher("/registererror.jsp");
		}
		rd.forward(request, response);
	}

}
