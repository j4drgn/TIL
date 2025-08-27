package com.mc.oop.g_factory;

/**
 * EmailConfig 열거형 - 메일 서버 설정 정보
 * 
 * 각 메일 서비스(NAVER, DAUM, GOOGLE)에 대한 연결 설정 정보를 정의합니다.
 * 열거형을 사용하여 제한된 상수 집합으로 관리합니다.
 */
public enum EmailConfig {
	
	/** 네이버 메일 서버 설정 */
	NAVER("smtp.naver.com", "mc", "123abc", 5000),
	
	/** 다음 메일 서버 설정 */
	DAUM("smtp.daum.com", "mc", "123abc", 5000),
	
	/** 구글 메일 서버 설정 */
	GOOGLE("smtp.google.com", "mc", "123abc", 5000);
	
	/** SMTP 서버 URL */
	public final String url;
	
	/** 사용자 ID */
	public final String id;
	
	/** 사용자 비밀번호 */
	public final String password;
	
	/** 연결 타임아웃(ms) */
	public final int timeout;
	
	/**
	 * EmailConfig 생성자
	 * @param url SMTP 서버 URL
	 * @param id 사용자 ID
	 * @param password 사용자 비밀번호
	 * @param timeout 연결 타임아웃(ms)
	 */
	private EmailConfig(String url, String id, String password, int timeout) {
		this.url = url;
		this.id = id;
		this.password = password;
		this.timeout = timeout;
	}
}
