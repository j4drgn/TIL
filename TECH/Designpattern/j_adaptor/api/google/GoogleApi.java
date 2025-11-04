package com.mc.oop.j_adaptor.api.google;

public class GoogleApi {

	public GoogleProfile getProfile(String token) {
		return new GoogleProfile("하명도", "aaa@bbb.com");
	}
	
}
