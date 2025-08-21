package com.mc.algorithm.d_datastructure.map;

import java.util.HashMap;

import com.mc.algorithm.d_datastructure.dto.School;

/**
 * 해시 맵 구현체의 기능을 테스트하는 실행 클래스
 * 
 * 이 클래스는 사용자 정의 해시 맵(_HashMap) 구현체의 기능을 테스트합니다.
 * School 객체를 사용하여 맵의 추가, 조회, 업데이트, 제거 기능을 시연합니다.
 */
public class Run {

	/**
	 * 메인 메소드 - 해시 맵의 기능 테스트
	 * 
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		// 테스트용 School 객체 생성
		School seoulUniv = new School("서울대", "관악구", "대학교");
		School yeonsaeUniv = new School("연세대", "서울", "대학교");
		School minsa = new School("민사고", "대전", "고등학교");
		School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");
		
		// 사용자 정의 해시 맵 생성 및 요소 추가
		_HashMap<String, School> schoolMap = new _HashMap<String, School>();
		schoolMap.put("seoulUniv", seoulUniv);
		schoolMap.put("yeonsaeUniv", yeonsaeUniv);
		schoolMap.put("minsa", minsa);
		schoolMap.put("multicampus", multicampus);
		
		// 맵의 모든 항목 출력
		System.out.println(schoolMap.entrySet());
		System.out.println("============================");
		
		// 기존 키에 새 값 할당 (업데이트)
		schoolMap.put("seoulUniv", new School("서울대 제주캠", "제주도", "대학교"));
		// 특정 키의 값 조회
		System.out.println(schoolMap.get("seoulUniv"));
		
		System.out.println("============================");
		// 항목 제거
		schoolMap.remove("seoulUniv");
		// 제거 후 맵의 모든 항목 출력
		System.out.println(schoolMap.entrySet());
	}
}
