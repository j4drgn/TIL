package com.mc.oop.j_adaptor.api.naver;


public class NaverApi {
	public NaverProfile getProfile(String token) {
		return new NaverProfile("하명도_naver", "aaa@naver.com");
	}
}
