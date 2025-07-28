package package1;

public class Example1 {
	public static void main(String[] args) {
		// 자바 변수 : type을 표현해야함
		int value1;
		int value = 10;
		value1 = 10;
		int result = value1 + 10;

		System.out.println(result);

		// 자바 상수 : 실행 중 값 기억 임시 기억장소(변수와 같음) 대입 후 실행 중 값이 변하지 않는다.
		// final 데이터 타입 상수명
		// 변수와 구분하기 위해 대문자로 명명
		final int PRICE = 1000;
		// PRICE = 200; 변경 불가능

		// 리터럴 : 변수에 저장되는 값
		// 정수, 실수, 문자, 문자열, 논리 리터럴
		value = 50; // 50 정수형 리터럴
		float valf = 50.2f;// 실수 리터럴
		char valch = 'a'; // 문자 리터럴
		String str = "abc"; // 문자열 리터럴
		boolean a = true; // 논리 리터럴

		// 데이터 타입
		// 기본 타입: byte/short/int(기본)/long float/double(기본) boolean char : 정수타입
		// 참조형 : 기본 타입 제외 나머지 모두 String

		int aint = 10;
		double bdouble = 5.2; // 기본 값 0.0d
		char chr = 'A'; // u0000
		boolean bool = false;

		long lint = 100L; // 8byte
		float fit = 5.0f; // 4byte
		short sint = 10; // 2byte
		byte bint = 1; // 1byte

		// 데이터 타입에 따라 사용 메모리 크기가 다름
		// 메모리 최소 단위 : bit -> 0/1 => 8개가 모여 1byte
		// bit : 2^1 표현 byte : 2^8 = 256

		float avg = 88.5f; // float은 뒤에 f,F 붙임
		double avg1 = 88.5;

		double var3 = 3e6; // 3뒤로 0을 6개 추가
		float var4 = 2e-3f; // 소수점 이하 3자리

		// String 타입(문자열) - 래퍼런스 타입
		String name = "홍길동";

	}
}
