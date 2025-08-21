package com.mc.algorithm.d_datastructure.map;

import java.util.Arrays;

import com.mc.algorithm.d_datastructure.list._LinkedList;
import com.mc.algorithm.d_datastructure.set._HashSet_P3;

/**
 * 제네릭 타입을 지원하는 해시 맵(HashMap) 구현 클래스
 * 
 * 이 클래스는 키-값 쌍을 저장하는 해시 기반 맵을 구현합니다.
 * 내부적으로 해시 테이블을 사용하여 데이터를 저장하고, 해시 충돌은 체이닝(연결 리스트)으로 처리합니다.
 * 
 * @param <K> 키의 타입
 * @param <V> 값의 타입
 */
@SuppressWarnings("unchecked")
public class _HashMap<K,V> {
	
	/** 맵에 저장된 요소의 개수 */
	private int size = 0;
	
	/** 키-값 쌍을 저장하는 해시 테이블 */
	private Object[] table;
	
	/** 내부 배열의 크기 */
	private int arraySize = 10;
	
	/** 맵의 모든 항목(Entry)을 저장하는 집합 */
	private _HashSet_P3<Entry<K,V>> entrySet = new _HashSet_P3<>();
	
	/**
	 * 기본 생성자
	 * 기본 크기(10)의 빈 해시 맵을 생성합니다.
	 */
	public _HashMap() {
		this.table = new Object[arraySize];
	}
	
	/**
	 * 지정된 초기 용량으로 해시 맵을 생성하는 생성자
	 * 
	 * @param initialCapacity 초기 용량
	 */
	public _HashMap(int initialCapacity) {
		this.table = new Object[initialCapacity];
	}
	
	/**
	 * 맵이 비어있는지 확인합니다.
	 * 
	 * @return 맵이 비어있으면 true, 그렇지 않으면 false
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 맵의 요소 개수를 반환합니다.
	 * 
	 * @return 맵의 요소 개수
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * 객체의 해시 코드를 계산하는 해시 함수
	 * 
	 * @param e 해시 코드를 계산할 객체
	 * @return 계산된 해시 코드(배열 인덱스)
	 */
	private int hash(Object e) {
		int hashCode = Math.abs(e.hashCode());
		return hashCode % arraySize;
	}
	
	/**
	 * 맵에 항목(Entry)을 추가하는 내부 메소드
	 * 
	 * @param entry 추가할 항목(키-값 쌍)
	 * @return 키가 이미 존재하는 경우 이전 값, 그렇지 않으면 null
	 */
	private V addEntry(Entry<K,V> entry) {
		// 해시 함수를 사용하여 인덱스 계산
		int index = hash(entry);
		_LinkedList<Entry<K,V>> row = (_LinkedList<Entry<K,V>>) table[index];
		
		// 해당 인덱스가 비어있는 경우, 새 연결 리스트 생성
		if(row == null) {
			_LinkedList<Entry<K,V>> newRow = new _LinkedList<Entry<K,V>>();
			newRow.add(entry);
			table[index] = newRow;
			entrySet.add(entry);
			return null;
		}
		
		// 이미 같은 키가 존재하는 경우, 값 업데이트
		if(row.contains(entry)) {
			int i = row.indexOf(entry);
			entrySet.remove(entry);
			
			V prevValue = row.get(i).getValue();
			row.remove(i);
			row.add(entry);
			entrySet.add(entry);
			return prevValue;
		}
		
		// 새 항목 추가
		row.add(entry);
		entrySet.add(entry);
		return null;
	}
	
	/**
	 * 내부 배열의 크기를 2배로 늘리는 메소드
	 * 
	 * 기존 요소들을 새 배열에 재배치합니다.
	 */
	private void resize() {
		// 기존 테이블 복사
		Object[] temp = Arrays.copyOf(table, arraySize);
		// 배열 크기를 2배로 증가
		arraySize *= 2;
		// 새 배열 생성
		table = new Object[arraySize];
		
		// 기존 요소들을 새 배열에 재배치
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] == null) continue;
			_LinkedList<Entry<K,V>> row = (_LinkedList<Entry<K,V>>) temp[i];
			
			for (Entry<K,V> e : row) {
				addEntry(e);
			}
		}
	}
	
	/**
	 * 맵에 키-값 쌍을 추가합니다.
	 * 
	 * 키가 이미 존재하는 경우, 값을 업데이트합니다.
	 * 배열이 가득 찬 경우, 배열 크기를 2배로 늘립니다.
	 * 
	 * @param key 추가할 키
	 * @param value 추가할 값
	 * @return 키가 이미 존재하는 경우 이전 값, 그렇지 않으면 null
	 */
	public V put(K key, V value) {
		// 배열이 가득 찬 경우, 크기 조정
		if(size == arraySize) {
			resize();
		}
		
		// 새 항목 추가
		V res = addEntry(new Entry<K, V>(key, value));
		size++;
		return res;
	}
	
	/**
	 * 지정된 키에 연결된 값을 반환합니다.
	 * 
	 * @param key 값을 가져올 키
	 * @return 키에 연결된 값, 키가 존재하지 않으면 null
	 */
	public V get(Object key) {
		// 더미 항목 생성(키만 사용하여 검색)
		Entry<K, V> dummy = new Entry<K, V>((K)key, null);
		int index = hash(dummy);
		_LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[index];
		
		// 해당 인덱스가 비어있는 경우
		if(row == null) return null;
		
		// 키가 존재하지 않는 경우
		if(!row.contains(dummy)) return null;
		// 키에 연결된 값 반환
		return row.get(row.indexOf(dummy)).getValue();
	}
	
	/**
	 * 지정된 키와 연결된 항목을 맵에서 제거합니다.
	 * 
	 * @param key 제거할 항목의 키
	 * @return 제거된 항목의 값, 키가 존재하지 않으면 null
	 */
	public V remove(K key) {
		// 더미 항목 생성(키만 사용하여 검색)
		Entry<K, V> dummy = new Entry<K, V>(key, null);
		int index = hash(dummy);

		_LinkedList<Entry<K, V>> row = (_LinkedList<Entry<K, V>>) table[index];
		
		// 해당 인덱스가 비어있는 경우
		if(row == null) return null;
		// 키가 존재하지 않는 경우
		if(!row.contains(dummy)) return null;
		
		// 항목 제거
		Entry<K, V> prevEntry = row.get(row.indexOf(dummy));
		row.remove(row.indexOf(dummy));
		entrySet.remove(dummy);
		// 행이 비어있으면 null로 설정
		if(row.isEmpty()) table[index] = null;
		
		size--;
		return prevEntry.getValue();
	}
	
	/**
	 * 맵의 모든 항목을 포함하는 집합을 반환합니다.
	 * 
	 * @return 맵의 모든 항목(Entry)을 포함하는 집합
	 */
	public _HashSet_P3<Entry<K,V>> entrySet(){
		return this.entrySet;
	}
}
