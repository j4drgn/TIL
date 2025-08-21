package com.mc.algorithm.d_datastructure.dto;

import java.util.Objects;

/**
 * 학교 정보를 표현하는 DTO(Data Transfer Object) 클래스
 * 
 * 이 클래스는 학교의 이름, 주소, 학교 레벨(초등학교, 중학교, 고등학교, 대학교 등)을 저장하고,
 * Comparable 인터페이스를 구현하여 학교 간 비교 기능을 제공합니다.
 * 또한 equals와 hashCode 메소드를 오버라이드하여 객체 비교와 해시 기반 컬렉션에서의 사용을 지원합니다.
 */
public class School implements Comparable<School>{
	
	/** 학교 이름 */
	private String name;
	
	/** 학교 주소 */
	private String address;
	
	/** 학교 레벨(초등학교, 중학교, 고등학교, 대학교 등) */
	private String level;
	
	/**
	 * School 객체의 생성자
	 * 
	 * @param name 학교 이름
	 * @param address 학교 주소
	 * @param level 학교 레벨(초등학교, 중학교, 고등학교, 대학교 등)
	 */
	public School(String name, String address, String level) {
		super();
		this.name = name;
		this.address = address;
		this.level = level;
	}
	
	/**
	 * 학교 이름을 반환하는 getter 메소드
	 * 
	 * @return 학교 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 학교 주소를 반환하는 getter 메소드
	 * 
	 * @return 학교 주소
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * 학교 레벨을 반환하는 getter 메소드
	 * 
	 * @return 학교 레벨(초등학교, 중학교, 고등학교, 대학교 등)
	 */
	public String getLevel() {
		return level;
	}
	
	/**
	 * 객체의 문자열 표현을 반환하는 메소드
	 * 
	 * @return 학교 정보를 포함한 문자열
	 */
	@Override
	public String toString() {
		return "School [name=" + name + ", address=" + address + ", level=" + level + "]";
	}
	
	/**
	 * 다른 School 객체와 비교하는 메소드
	 * 
	 * 비교 기준:
	 * 1. 먼저 학교 레벨(level)을 기준으로 오름차순 정렬
	 * 2. 학교 레벨이 같은 경우, 학교 이름(name)을 기준으로 내림차순 정렬
	 * 
	 * @param o 비교할 다른 School 객체
	 * @return 이 객체가 매개변수보다 작으면 음수, 같으면 0, 크면 양수
	 */
	@Override
	public int compareTo(School o) {
		// 학교 레벨 비교
		if(this.level.compareTo(o.level) == 0) {
			// 레벨이 같으면 이름으로 내림차순 정렬 (음수를 곱해 순서를 반전)
			return this.name.compareTo(o.name) * -1;
		}
		// 레벨이 다르면 레벨로 오름차순 정렬
		return this.level.compareTo(o.level);
	}
	
	/**
	 * 객체의 해시 코드를 계산하는 메소드
	 * 
	 * 이 메소드는 학교의 이름, 주소, 레벨을 기반으로 해시 코드를 생성합니다.
	 * HashSet, HashMap 등의 해시 기반 컬렉션에서 객체를 식별하는 데 사용됩니다.
	 * 
	 * @return 객체의 해시 코드
	 */
	@Override
	public int hashCode() {
		return Objects.hash(address, level, name);
	}
	
	/**
	 * 이 객체와 다른 객체가 동일한지 비교하는 메소드
	 * 
	 * 두 School 객체는 이름, 주소, 레벨이 모두 동일할 때 같은 객체로 간주됩니다.
	 * 
	 * @param obj 비교할 객체
	 * @return 두 객체가 동일하면 true, 그렇지 않으면 false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)  // 동일한 참조인 경우
			return true;
		if (obj == null)  // 비교 대상이 null인 경우
			return false;
		if (getClass() != obj.getClass())  // 클래스 타입이 다른 경우
			return false;
		School other = (School) obj;  // School 타입으로 형변환
		// 모든 필드가 동일한지 비교
		return Objects.equals(address, other.address) && Objects.equals(level, other.level)
				&& Objects.equals(name, other.name);
	}
}