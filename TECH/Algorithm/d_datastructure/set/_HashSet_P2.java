package com.mc.algorithm.d_datastructure.set;

import com.mc.algorithm.d_datastructure.list.Node;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 체이닝 방식으로 해시 충돌을 처리하는 해시 집합 구현 클래스
 * 
 * 이 클래스는 해시 함수를 사용하여 요소를 저장하는 집합을 구현합니다.
 * 해시 충돌이 발생하면 연결 리스트(체이닝)를 사용하여 처리합니다.
 * 제네릭 타입 E를 사용하여 다양한 타입의 요소를 저장할 수 있습니다.
 * 
 * @param <E> 집합에 저장될 요소의 타입
 */
@SuppressWarnings("unchecked")
public class _HashSet_P2<E> implements Iterable<E> {

  /** 내부 배열의 크기 */
  private int arraySize = 6;
  
  /** 요소를 저장하는 해시 테이블 */
  private Object[] table;
  
  /** 집합의 요소 개수 */
  private int size;

  /**
   * 기본 생성자
   * 기본 크기(6)의 빈 해시 집합을 생성합니다.
   */
  public _HashSet_P2() {
    this.table = new Object[arraySize];
  }

  /**
   * 지정된 초기 용량으로 해시 집합을 생성하는 생성자
   * 
   * @param initialCapacity 초기 용량
   */
  public _HashSet_P2(int initialCapacity) {
    this.table = new Object[initialCapacity];
  }

  /**
   * 집합이 비어있는지 확인합니다.
   * 
   * @return 집합이 비어있으면 true, 그렇지 않으면 false
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * 집합의 요소 개수를 반환합니다.
   * 
   * @return 집합의 요소 개수
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
   * 집합에 요소를 추가합니다.
   * 
   * 배열이 거의 가득 찬 경우, 배열 크기를 2배로 늘립니다.
   * 
   * @param e 추가할 요소
   * @return 요소가 성공적으로 추가되면 true, 이미 존재하면 false
   */
  public boolean add(E e) {
    Node<E> node = new Node<E>(e);

    // 배열이 거의 가득 찬 경우, 크기 조정
    if (size == arraySize - 1) {
      resize();
    }

    // 노드 추가 시도
    if (!addNode(e)) {
      return false;
    }
    size++;

    return true;
  }

  /**
   * 내부적으로 노드를 추가하는 메소드
   * 
   * 해시 충돌이 발생하면 체이닝(연결 리스트)을 사용하여 처리합니다.
   * 
   * @param e 추가할 요소
   * @return 요소가 성공적으로 추가되면 true, 이미 존재하면 false
   */
  private boolean addNode(E e) {
    // 해시 함수를 사용하여 인덱스 계산
    int index = hash(e);
    Node<E> node = new Node<>(e);
    Node<E> head = (Node<E>) table[index];

    // 해당 인덱스가 비어있으면 새 노드 추가
    if (head == null) {
      table[index] = node;
      return true;
    }

    // 연결 리스트 순회하며 중복 확인 및 마지막 노드 찾기
    Node<E> link = head;
    while (link.next() != null) {
      // 중복된 요소가 있으면 추가 실패
      if (link.data().equals(e)) {
        return false;
      }
      link = link.next();
    }

    // 마지막 노드도 중복 확인
    if (link.data().equals(e)) {
      return false;
    }
    // 마지막 노드 다음에 새 노드 연결
    link.next(node);

    return true;
  }

  /**
   * 집합에서 요소를 제거합니다.
   * 
   * @param data 제거할 요소
   * @return 요소가 성공적으로 제거되면 true, 존재하지 않으면 false
   */
  public boolean remove(E data) {
    // 해시 함수를 사용하여 인덱스 계산
    int index = hash(data);
    Node<E> head = (Node<E>) table[index];

    // 해당 인덱스가 비어있으면 제거 실패
    if (head == null) {
      return false;
    }
    
    // 첫 번째 노드가 제거할 요소인 경우
    if (head.data().equals(data)) {
      table[index] = head.next();
      size--;
      return true;
    }

    // 연결 리스트 순회하며 제거할 요소 찾기
    Node<E> link = head.next();
    Node<E> prev = head;

    while (link != null) {
      if (link.data().equals(data)) {
        // 이전 노드를 제거할 노드의 다음 노드와 연결
        prev.next(link.next());
        size--;
        return true;
      }
      prev = link;
      link = link.next();
    }

    // 요소를 찾지 못한 경우
    return false;
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
      if (temp[i] == null) {
        continue;
      }
      
      // 각 인덱스의 연결 리스트를 순회하며 요소 재배치
      Node<E> link = (Node<E>) temp[i];
      while (link != null) {
        addNode(link.data());
        link = link.next();
      }
    }
  }

  /**
   * 집합의 문자열 표현을 반환합니다.
   * 
   * @return 집합의 내용을 포함한 문자열
   */
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    
    // 모든 요소를 순회하며 문자열에 추가
    for (int i = 0; i < table.length; i++) {
      if (table[i] == null) {
        continue;
      }
      
      Node<E> link = (Node<E>) table[i];
      while (link != null) {
        sb.append(link.data());
        sb.append(", ");
        link = link.next();
      }
    }

    // 마지막 쉼표 제거 및 닫는 괄호 추가
    if (sb.length() > 1) {
      sb.deleteCharAt(sb.lastIndexOf(","));
    }
    sb.append("]");
    return sb.toString();
  }

  /**
   * 집합의 반복자(Iterator)를 반환
   * 
   * 이 메소드는 Iterable 인터페이스 구현의 일부로,
   * 향상된 for문(for-each)에서 집합을 사용할 수 있게 합니다.
   * 
   * @return 집합의 요소를 순회할 수 있는 Iterator 객체
   */
  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      // 현재 테이블 인덱스
      private int tableIndex = 0;
      // 현재 노드
      private Node<E> current = null;
      // 다음 노드
      private Node<E> next = getFirstNode();
      // 반환된 요소의 개수
      private int returnedCount = 0;
      
      /**
       * 테이블에서 첫 번째 유효한 노드를 찾는 메소드
       * 
       * @return 첫 번째 유효한 노드, 없으면 null
       */
      private Node<E> getFirstNode() {
        // 테이블이 비어있으면 null 반환
        if (size == 0) {
          return null;
        }
        
        // 첫 번째 유효한 노드를 찾음
        for (int i = 0; i < table.length; i++) {
          if (table[i] != null) {
            tableIndex = i;
            return (Node<E>) table[i];
          }
        }
        
        return null;
      }
      
      /**
       * 다음 유효한 노드를 찾는 메소드
       * 
       * @return 다음 유효한 노드, 없으면 null
       */
      private Node<E> getNextNode() {
        // 현재 노드가 null이면 첫 번째 노드를 반환
        if (current == null) {
          return getFirstNode();
        }
        
        // 현재 노드의 다음 노드가 있으면 반환
        if (current.next() != null) {
          return current.next();
        }
        
        // 현재 노드의 다음 노드가 없으면 다음 테이블 인덱스에서 찾음
        for (int i = tableIndex + 1; i < table.length; i++) {
          if (table[i] != null) {
            tableIndex = i;
            return (Node<E>) table[i];
          }
        }
        
        // 더 이상 노드가 없으면 null 반환
        return null;
      }

      /**
       * 다음 요소가 있는지 확인합니다.
       * 
       * @return 다음 요소가 있으면 true, 없으면 false
       */
      @Override
      public boolean hasNext() {
        // 다음 노드가 있고, 반환된 요소의 개수가 전체 크기보다 작으면 true
        return next != null && returnedCount < size;
      }

      /**
       * 다음 요소를 반환하고 포인터를 증가시킵니다.
       * 
       * @return 다음 요소
       * @throws NoSuchElementException 더 이상 요소가 없는 경우
       */
      @Override
      public E next() {
        // 다음 요소가 없으면 예외 발생
        if (!hasNext()) {
          throw new NoSuchElementException("더 이상 요소가 없습니다.");
        }
        
        // 현재 노드를 다음 노드로 설정
        current = next;
        // 다음 노드를 갱신
        next = getNextNode();
        // 반환된 요소의 개수 증가
        returnedCount++;
        
        // 현재 노드의 데이터 반환
        return current.data();
      }
    };
  }
}