package com.mc.oop.f_builder;

/**
 * 빌더 패턴 실행 예제 클래스
 * 
 * 빌더 패턴을 사용하여 Book 객체를 생성하고 출력하는 예제입니다.
 */
public class Run {
	
	/**
	 * 메인 메서드 - 빌더 패턴 사용 예시
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		// 빌더 패턴을 사용한 Book 객체 생성
		// 메서드 체이닝을 통해 가독성 높은 코드로 객체 생성
		Book book = new Book.Builder()
				.title("해리포터")    // 책 제목 설정
				.author("포터해리")   // 저자 설정
				.price(90000)      // 가격 설정
				.page(300)         // 페이지 수 설정
				.build();          // 최종 객체 생성
		
		// 생성된 Book 객체 출력
		System.out.println(book);
	}
}
