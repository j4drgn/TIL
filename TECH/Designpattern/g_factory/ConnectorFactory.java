package com.mc.oop.g_factory;

/**
 * ConnectorFactory 클래스 - SMTP 커넥터 객체 생성을 담당하는 팩토리 클래스
 * 
 * 팩토리 패턴에서 팩토리(Factory) 역할을 하는 클래스입니다.
 * 클라이언트 코드와 객체 생성 로직을 분리하여 결합도를 낮춥니다.
 */
public class ConnectorFactory {

	/**
	 * 설정에 따른 적절한 SMTP 커넥터 객체를 생성하는 정적 팩토리 메서드
	 * 
	 * @param config 메일 서버 설정 정보(EmailConfig)
	 * @return 생성된 SMTPConnector 구현체
	 * @throws IllegalArgumentException 지원하지 않는 설정인 경우 발생
	 */
	public static SMTPConnector create(EmailConfig config) {
		switch (config) {
		
		case DAUM: {
			// 다음 메일 커넥터 객체 생성
			return new DaumMail(config);
		}
		case NAVER: {
			// 네이버 메일 커넥터 객체 생성
			return new NaverMail(config);
		}
		case GOOGLE: {
			// 구글 메일 커넥터 객체 생성
			return new GoogleMail(config);
		}
		
		default:
			// 지원하지 않는 설정인 경우 예외 발생
			throw new IllegalArgumentException("Unexpected value: " + config);
		}
	}
}
