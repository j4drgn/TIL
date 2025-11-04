package com.mc.oop.j_adaptor;

import com.mc.oop.j_adaptor.auth.AuthService;
import com.mc.oop.j_adaptor.user.UserController;

public class Run {

	public static void main(String[] args) {
		UserController userController = new UserController(new AuthService());
		String response = userController.naverLogin();
		System.out.println(response);
	}
	
}
