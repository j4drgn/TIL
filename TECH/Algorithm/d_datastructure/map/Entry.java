package com.mc.algorithm.d_datastructure.map;

import java.util.Objects;

/**
 * 해시 맵에서 사용되는 키-값 쌍을 표현하는 Entry 클래스
 * 
 * 이 클래스는 해시 맵에서 각 항목을 저장하는 데 사용됩니다.
 * 키와 값을 쌍으로 저장하며, 키를 기준으로 동등성을 비교합니다.
 * 
 * @param <K> 키의 타입
 * @param <V> 값의 타입
 */
public class Entry<K,V> {
	
	/** 항목의 키 */
	private K key;
	
	/** 항목의 값 */
	private V value;
	
	/**
	 * 키와 값을 지정하여 Entry를 생성하는 생성자
	 * 
	 * @param key 항목의 키
	 * @param value 항목의 값
	 */
	public Entry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * 항목의 값을 반환하는 getter 메소드
	 * 
	 * @return 항목의 값
	 */
	public V getValue() {
		return value;
	}

	/**
	 * 항목의 값을 설정하는 setter 메소드
	 * 
	 * @param value 설정할 값
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * 항목의 키를 반환하는 getter 메소드
	 * 
	 * @return 항목의 키
	 */
	public K getKey() {
		return key;
	}

	/**
	 * 객체의 해시 코드를 계산하는 메소드
	 * 
	 * 이 메소드는 키를 기준으로 해시 코드를 생성합니다.
	 * HashMap에서 항목을 저장하고 검색하는 데 사용됩니다.
	 * 
	 * @return 객체의 해시 코드
	 */
	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	/**
	 * 이 객체와 다른 객체가 동일한지 비교하는 메소드
	 * 
	 * 두 Entry 객체는 키가 동일할 때 같은 객체로 간주됩니다.
	 * 값은 비교에 사용되지 않습니다.
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
		Entry other = (Entry) obj;  // Entry 타입으로 형변환
		return Objects.equals(key, other.key);  // 키만 비교
	}

	/**
	 * 객체의 문자열 표현을 반환하는 메소드
	 * 
	 * @return 키와 값을 포함한 문자열 표현
	 */
	@Override
	public String toString() {
		return "Entry [key=" + key + ", value=" + value + "]";
	}
}
