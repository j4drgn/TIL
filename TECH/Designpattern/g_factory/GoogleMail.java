package com.mc.oop.g_factory;

/**
 * GoogleMail 클래스 - 구글 메일 서버 연결을 담당하는 클래스
 * 
 * SMTPConnector 인터페이스를 구현하여 구글 메일 서버에 특화된 연결 로직을 제공합니다.
 * 팩토리 패턴에서 구체적인 제품(Concrete Product) 역할을 합니다.
 */
public class GoogleMail implements SMTPConnector {

	/** 메일 서버 설정 정보 */
	private EmailConfig config;
	
	/**
	 * GoogleMail 생성자
	 * @param config 메일 서버 설정 정보
	 */
	public GoogleMail(EmailConfig config) {
		super();
		this.config = config;
	}

	/**
	 * 구글 메일 서버 연결 메서드
	 * SMTPConnector 인터페이스의 connect 메서드 구현
	 */
	@Override
	public void connect() {
		System.out.println(config.url);
		System.out.println("구글 메일서버에 연결되었습니다.");
	}
}
