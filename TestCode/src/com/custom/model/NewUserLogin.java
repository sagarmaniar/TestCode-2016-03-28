package com.custom.model;

import com.custom.service.LoginService;

public class NewUserLogin {

	public String NewLogin(String username, String password) {
		LoginService loginService= new LoginService();
		boolean status=loginService.UpdateUser(username, password);
		if (status)
		{
	return "success";
} else {
	return "failure";
}
}
}