package com.custom.model;

import com.custom.service.LoginService;

public class Authenticator {
	
	public String authenticate(String username, String password) {
		LoginService loginService= new LoginService();
		boolean status=loginService.Authenticate(username, password);
		System.out.println("status in authenticator>>"+status);;
		if (status)
				{
			return "success";
		} else {
			return "failure";
		}
	}
	
}
