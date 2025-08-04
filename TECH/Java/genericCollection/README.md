# Java 제네릭과 컬렉션 프레임워크

## 제네릭(Generic)

제네릭은 클래스, 인터페이스, 메소드를 정의할 때 타입을 파라미터로 사용할 수 있게 하는 기능입니다. 컴파일 시점에 타입을 체크하여 안전한 코드를 작성할 수 있게 해줍니다.

### 제네릭의 장점
- 컴파일 시점에 타입 체크를 통한 안전성 확보
- 불필요한 타입 변환 제거로 성능 향상
- 재사용성이 높은 코드 작성 가능

### 예제 구성

#### sec01 - Object 타입을 이용한 모든 타입 저장
- [Box.java](./sec01/Box.java): Object 타입을 사용하여 모든 타입의 객체를 저장할 수 있는 Box 클래스
- [BoxMain.java](./sec01/BoxMain.java): Object 타입 사용 시 발생하는 형변환 문제 예시

#### sec02 - 제네릭 클래스 기본
- [Box.java](./sec02/Box.java): 제네릭 타입 파라미터를 사용한 Box 클래스
- [BoxGenMain.java](./sec02/BoxGenMain.java): 제네릭 클래스 사용 예시

#### sec03 - 제네릭 클래스 활용
- [Car.java](./sec03/Car.java): 제네릭에서 사용할 Car 클래스
- [Product.java](./sec03/Product.java): 제네릭에서 사용할 Product 클래스
- [ProductMain.java](./sec03/ProductMain.java): 다양한 타입의 제네릭 클래스 활용

#### sec04 - 제네릭 메소드
- [Box.java](./sec04/Box.java): 제네릭 클래스
- [Util.java](./sec04/Util.java): 제네릭 메소드 정의
- [UtilMain.java](./sec04/UtilMain.java): 제네릭 메소드 호출 예시

#### sec05 - 제한된 타입 파라미터
- [CompareMain.java](./sec05/CompareMain.java): 제한된 타입 파라미터 사용 예시
- [Pair.java](./sec05/Pair.java): 키와 값을 저장하는 제네릭 클래스
- [Util.java](./sec05/Util.java): 제한된 타입 파라미터를 갖는 제네릭 메소드

#### sec06 - ArrayList
- [ArrayListExample.java](./sec06/ArrayListExample.java): ArrayList 활용 예제
- [ArrayListMain.java](./sec06/ArrayListMain.java): ArrayList 기본 사용법
- [AsListMain.java](./sec06/AsListMain.java): Arrays.asList() 메소드 활용

#### sec07 - Employee 관리 예제
- [Employee.java](./sec07/Employee.java): 직원 클래스
- [EmployeeMain.java](./sec07/EmployeeMain.java): ArrayList를 활용한 직원 관리 예제

#### sec08 - LinkedList
- [LinkedListEx.java](./sec08/LinkedListEx.java): ArrayList와 LinkedList 성능 비교
- [Product.java](./sec08/Product.java): 제품 클래스
- [ProductMain.java](./sec08/ProductMain.java): LinkedList를 활용한 제품 관리 예제

#### sec09 - Vector
- [Board.java](./sec09/Board.java): 게시글 클래스
- [VetorBoarMain.java](./sec09/VetorBoarMain.java): Vector를 활용한 게시글 관리 예제

#### sec11 - HashSet 기본
- [HashSetStringEx.java](./sec11/HashSetStringEx.java): HashSet을 활용한 문자열 중복 제거 예제

#### sec12 - HashSet과 객체 동등성
- [Member.java](./sec12/Member.java): 기본 회원 클래스
- [Member2.java](./sec12/Member2.java): hashCode()와 equals() 메소드를 재정의한 회원 클래스
- [HashSetMain.java](./sec12/HashSetMain.java): 객체 동등성 비교 예제

#### sec13 - HashMap 기본
- [HashMapEx.java](./sec13/HashMapEx.java): HashMap 기본 사용법 예제

#### sec14 - HashMap 활용
- [HashMapExample.java](./sec14/HashMapExample.java): HashMap을 활용한 영한사전 예제

#### sec15 - HashMap과 사용자 정의 객체
- [Student.java](./sec15/Student.java): 학생 클래스
- [HashMapStudent.java](./sec15/HashMapStudent.java): 학생 객체를 키로 사용하는 HashMap 예제

#### sec16 - Hashtable
- [HashTableEx.java](./sec16/HashTableEx.java): Hashtable을 활용한 로그인 예제

#### 컬렉션 정렬
- [SortCollection.java](./SortCollection.java): Collections 클래스의 sort()와 reverse() 메소드 활용 예제

## 컬렉션 프레임워크(Collection Framework)

컬렉션 프레임워크는 데이터를 저장하고 관리하기 위한 클래스들의 집합입니다.

### 주요 인터페이스
- List: 순서가 있는 데이터 집합, 중복 허용
- Set: 순서가 없는 데이터 집합, 중복 불허
- Map: 키와 값의 쌍으로 이루어진 데이터 집합, 키 중복 불허

### 주요 구현 클래스
- ArrayList: 내부적으로 배열을 사용하는 List 구현체
- LinkedList: 노드 기반의 양방향 연결 리스트
- HashSet: 해시 알고리즘을 사용하는 Set 구현체
- HashMap: 해시 알고리즘을 사용하는 Map 구현체
- Vector: 스레드 안전한 ArrayList
- Hashtable: 스레드 안전한 HashMap
- LinkedHashMap: 입력 순서를 유지하는 HashMap