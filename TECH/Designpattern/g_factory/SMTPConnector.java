package com.mc.oop.g_factory;

/**
 * SMTPConnector 인터페이스 - 메일 서버 연결을 위한 공통 인터페이스
 * 
 * 팩토리 패턴에서 제품(Product) 역할을 하는 인터페이스입니다.
 * 모든 메일 서버 연결 클래스가 구현해야 하는 공통 메서드를 정의합니다.
 */
public interface SMTPConnector {
	/**
	 * 메일 서버에 연결하는 메서드
	 * 각 구현 클래스에서 서버별 연결 로직을 구현합니다.
	 */
	void connect();
}
