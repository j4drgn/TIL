package com.mc.algorithm.d_datastructure.set;

import com.mc.algorithm.d_datastructure.dto.School;

/**
 * 해시 집합(HashSet) 구현체의 기능을 테스트하는 실행 클래스
 * 
 * 이 클래스는 체이닝 방식으로 해시 충돌을 처리하는 _HashSet_P2 구현체의
 * 기능을 테스트합니다. School 객체를 사용하여 추가 및 제거 기능을 시연합니다.
 */
public class Run {

	/**
	 * 메인 메소드 - 해시 집합의 기능 테스트
	 * 
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		// 테스트용 School 객체 생성
		School seoulUniv = new School("서울대", "관악구", "대학교");
		School yeonsaeUniv = new School("연세대", "서울", "대학교");
		School minsa = new School("민사고", "대전", "고등학교");
		School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");
		
		// 체이닝 방식의 해시 집합 생성
		_HashSet_P2<School> set = new _HashSet_P2<School>();
		
		// 해시 집합에 School 객체 추가
		set.add(seoulUniv);
		set.add(yeonsaeUniv);
		set.add(minsa);
		set.add(multicampus);
		
		// 현재 집합 내용 출력
		System.out.println(set);
		
		// equals 메소드를 사용한 객체 제거
		// 내용이 같은 새 School 객체를 생성하여 제거 테스트
		set.remove(new School("서울대", "관악구", "대학교"));
		
		// 요소 제거 후 집합 내용 출력
		System.out.println(set);

		for (School school : set) {
			System.out.println(school);
		}
	}
}