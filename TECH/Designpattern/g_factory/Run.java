package com.mc.oop.g_factory;

/**
 * 팩토리 패턴 실행 예제 클래스
 * 
 * 팩토리 패턴을 사용하여 메일 서버 연결 객체를 생성하고 사용하는 예제입니다.
 */
public class Run {
	
	/**
	 * 메인 메서드 - 팩토리 패턴 사용 예시
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		// 팩토리를 통해 구글 메일 커넥터 객체 생성
		// 클라이언트 코드는 구체적인 구현 클래스를 알 필요 없이 인터페이스만 사용
		SMTPConnector connector = ConnectorFactory.create(EmailConfig.GOOGLE);
		
		// 생성된 커넥터 객체를 통해 메일 서버 연결
		connector.connect();
	}
}
