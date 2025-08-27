package com.mc.oop.f_builder;

/**
 * Book 클래스 - 빌더 패턴(Builder Pattern)을 적용한 불변 객체
 * 
 * 빌더 패턴은 복잡한 객체의 생성 과정과 표현 방법을 분리하여
 * 다양한 구성의 인스턴스를 생성할 수 있게 해주는 생성 패턴입니다.
 */
public class Book {
	
	// 불변(immutable) 객체를 위한 private 필드
	private String title;   // 책 제목
	private String author;  // 저자
	private int page;       // 페이지 수
	private int price;      // 가격
	
	/**
	 * private 생성자 - 오직 Builder를 통해서만 객체 생성 가능
	 * @param builder 책 객체를 생성하기 위한 빌더 객체
	 */
	private Book(Builder builder) {
		title = builder.title;
		author = builder.author;
		page = builder.page;
		price = builder.price;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", page=" + page + ", price=" + price + "]";
	}

	/**
	 * Builder 클래스 - Book 객체 생성을 위한 빌더
	 * 메서드 체이닝을 통해 가독성 높은 객체 생성 코드 작성 가능
	 */
	public static class Builder {
		// Book과 동일한 필드를 가짐
		private String title;
		private String author;
		private int page;
		private int price;
		
		/**
		 * 책 제목 설정
		 * @param title 책 제목
		 * @return 빌더 자신을 반환하여 메서드 체이닝 지원
		 */
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		/**
		 * 저자 설정
		 * @param author 저자
		 * @return 빌더 자신을 반환하여 메서드 체이닝 지원
		 */
		public Builder author(String author) {
			this.author = author;
			return this;
		}
		
		/**
		 * 페이지 수 설정
		 * @param page 페이지 수
		 * @return 빌더 자신을 반환하여 메서드 체이닝 지원
		 */
		public Builder page(int page) {
			this.page = page;
			return this;
		}
		
		/**
		 * 가격 설정
		 * @param price 가격
		 * @return 빌더 자신을 반환하여 메서드 체이닝 지원
		 */
		public Builder price(int price) {
			this.price = price;
			return this;
		}
		
		/**
		 * 최종적으로 Book 객체 생성 및 반환
		 * @return 설정된 값으로 생성된 Book 객체
		 */
		public Book build() {
			return new Book(this);
		}
	}
	
	
	// [자바빈패턴]
	// 기본생성자로 인스턴스생성 + setter 로 초기화
	// 가독성이 좋다.
	//     ex)Book book = new Book();
	//			book.setAuthor("포터해리");
	// immutable 객체를 생성할 수 없다.
	
	// [점층적 생성자 패턴]
	//  매개변수가 있는 생성자를 사용해서 인스턴스화와 동시에 초기화
	// 가독성이 좋지 않다.
	//		ex) new Book("해리포터", "포터해리", 9999, 9000);
	// immutable 객체를 생성할 수 있다.
	
	// [builder 패턴]
	// 가독성이 좋고 immutable 객체도 만들 수 있다.
}
