package com.mc.oop.j_adaptor.user;

import com.mc.oop.j_adaptor.auth.AuthService;
import com.mc.oop.j_adaptor.auth.SocialLoginProvider;

public class UserController {

	private final AuthService userService;

	public UserController(AuthService userService) {
		super();
		this.userService = userService;
	}
	
	public String gooleLogin() {
		userService.socialLogin(SocialLoginProvider.GOOGLE, "abc");
		return "200 OK";
	}
	
	public String naverLogin() {
		userService.socialLogin(SocialLoginProvider.NAVER, "abc");
		return "200 OK";
	}
	
}
