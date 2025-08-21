package com.mc.algorithm.d_datastructure.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.mc.algorithm.d_datastructure.dto.School;

/**
 * 리스트 구현체들의 기능을 테스트하는 실행 클래스
 * 
 * 이 클래스는 사용자 정의 LinkedList 구현체의 다양한 기능을 테스트하고,
 * Collections 클래스를 사용한 정렬 기능도 함께 시연합니다.
 */
public class Run {

	/**
	 * 메인 메소드 - 다양한 리스트 기능 테스트
	 * 
	 * @param args 명령행 인자
	 */
	public static void main(String[] args) {
		System.out.println(init());
		//testGet();       // 요소 접근 테스트
		//testRemove();    // 요소 제거 테스트
		testForEach();     // 반복자를 사용한 순회 테스트
		//testSet();       // 요소 교체 테스트
		//testSort();      // 정렬 테스트
	}

	/**
	 * 정렬 기능을 테스트하는 메소드
	 * 
	 * School 객체들을 생성하고 다양한 기준으로 정렬합니다.
	 * 1. Comparable 인터페이스를 사용한 기본 정렬
	 * 2. Comparator를 사용한 람다식 기반 정렬
	 */
	private static void testSort() {
		// 테스트용 School 객체 생성
		School seoulUniv = new School("서울대", "관악구", "대학교");
		School yeonsaeUniv = new School("연세대", "서울", "대학교");
		School minsa = new School("민사고", "대전", "고등학교");
		School multicampus = new School("멀티캠퍼스", "역삼", "아카데미");
		
		// ArrayList에 School 객체 추가
		ArrayList<School> schools = new ArrayList<School>();
		schools.add(seoulUniv);
		schools.add(yeonsaeUniv);
		schools.add(minsa);
		schools.add(multicampus);
		
		// 레벨을 기준으로 오름차순 정렬, 대학이 같다면 이름으로 내림차순 정렬 (Comparable 사용)
		Collections.sort(schools);
		
		// 이름을 기준으로 오름차순 정렬 (Comparator 람다식 사용)
		Collections.sort(schools, (o1, o2) -> o1.getName().compareTo(o2.getName()));
		System.out.println(schools);
	}

	/**
	 * 요소 교체(set) 기능을 테스트하는 메소드
	 */
	private static void testSet() {
		_LinkedList<Integer> list = init();
		// 첫 번째 요소(인덱스 0)를 10으로 교체하고 이전 값 출력
		System.out.println(list.set(0, 10));
		// 변경된 리스트 출력
		System.out.println(list);
	}

	/**
	 * 향상된 for문(for-each)을 사용한 리스트 순회 테스트 메소드
	 * 
	 * 이 메소드는 Iterator 패턴을 사용하여 리스트를 순회하는 방법을 보여줍니다.
	 * 제어 반전(IoC) 패턴의 예시이기도 합니다.
	 */
	private static void testForEach() {
		// 제어반전 IOC (Inversion of Control)
		_LinkedList<Integer> list = init();
		// 향상된 for문을 사용하여 각 요소 출력
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

	/**
	 * 요소 제거(remove) 기능을 테스트하는 메소드
	 */
	private static void testRemove() {
		_LinkedList<Integer> list = init();
		// 인덱스 5부터 7까지의 요소 제거
		for (int i = 5; i < 8; i++) {
			list.remove(i);
		}
		// 변경된 리스트 출력
		System.out.println(list);
	}

	/**
	 * 요소 접근(get) 기능을 테스트하는 메소드
	 */
	private static void testGet() {
		_LinkedList<Integer> list = init();
		// 인덱스 5부터 7까지의 요소 출력
		for (int i = 5; i < 8; i++) {
			System.out.println(list.get(i));
		}
	}

	/**
	 * 테스트용 LinkedList를 초기화하는 메소드
	 * 
	 * 0부터 14까지의 정수를 포함하는 LinkedList를 생성합니다.
	 * 
	 * @return 초기화된 LinkedList
	 */
	private static _LinkedList<Integer> init() {
		_LinkedList<Integer> list = new _LinkedList<Integer>();
		// 0부터 14까지의 정수를 리스트에 추가
		for (int i = 0; i < 15; i++) {
			list.add(i);
		}
		
		return list;
	}
}