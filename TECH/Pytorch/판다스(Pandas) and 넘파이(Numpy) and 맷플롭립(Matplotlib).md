# 1. Pandas
### Pandas란? 파이썬 데이터 처리를 위한 라이브러리
### Pandas는 총 세 가지의 데이터 구조를 사용
### - 시리즈(Series)
### - 데이터프레임(DataFrame)
### - 패널(Panel)
### 이 중 데이터 프레임이 가장 많이 사용된다.

## 1) 시리즈(Series)
### 시리즈 클래스는 1차원 배열의 값(Values)에 각 값에 대응되는 인덱스(index)를 부여할 수 있는 구조

![[Pasted image 20241001215903.png]]
### 값(values)과 인덱스(index)를 출력

![[Pasted image 20241001220022.png]]

## 2) 데이터프레임(DataFrame)
### 데이터프레임은 2차원 리스트를 매개 변수로 전달, 행과 열을 가지는 자료 구조. 
DataFrame은 열(columns), 인덱스(index), 값(Values)으로 구성

![[Pasted image 20241001220933.png]]

## 3) 데이터프레임의 생성
### 데이터프레임은 리스트(List), 시리즈(Series), 딕셔너리(dict), Numpy의 ndarrays, 또 다른 데이터 프레임으로부터 생성할 수 있다.

이중 리스트로 생성하는 경우

![[Pasted image 20241001222300.png | 300]]

### 열이름 지정하고 출력하기

![[Pasted image 20241001222756.png]]

딕셔너리로 데이터프레임 생성하기

![[Pasted image 20241001222941.png]]

## 4) 데이터프레임 조회하기
### 데이터프레임에서 원하는 구간만 확인하기 위한 명령어
### - df.head(n) : 앞 부분을 n개만 보기
### - df.tail(n) : 뒷 부분을 n개만 보기
### - df['열이름'] : 해당되는 열을 확인

![[Pasted image 20241001223410.png | 200]]
![[Pasted image 20241001223455.png | 200]]
![[Pasted image 20241001223514.png | 200]]

## 5) 외부 데이터 읽기
### 다양한 데이터 파일을 읽고 데이터 프레임을 생성할 수 있음, csv파일 기준으로 pandas.read_csv()을 이용
### 예시 : example.csv라는 파일이 있다면, df = pd.read_csv("example.csv)처럼 사용

# 2. 넘파이(Numpy)
### 수치 데이터를 다루는 파이썬 패키지. 다차원 행렬 구조인 ndarray()를 사용하여 선형대수 계산에서 주로 사용함. 또한 순수 파이썬을 통한 계산보다 편의성과 속도에서 압도적인 성능 자랑함.

## 1) np.array()
### Nnd차원의 배열(array)라는 뜻. 리스트,튜플,배열로부터 ndarray를 생성하는 명령어.


![[Pasted image 20241002092831.png | 300]]

![[Pasted image 20241002092850.png|300]]

![[Pasted image 20241002092859.png|300]]

![[Pasted image 20241002092910.png|300]]

![[Pasted image 20241002092921.png|300]]
 
## 2) ndarray의 초기화
### ndarray를 만드는 다양한 방법이 존재함.
- ### np.zeros() : 배열의 모든 원소에 0을 삽입하는 함수.
- ### np.ones() : 배열의 모든 원소에 1을 삽입하는 함수.
- ### np.full() : 배열에 사용자가 지정한 값을 삽입하는 함수.
- ### np.eye() : 대각선에는 1을 삽입하고 나머지에는 0인 2차원 배열을 생성하는 함수.
- ### np.random.random() : 배열에 임의의 값을 삽입하는 함수.

## 3) np.arange() : 0부터 **n-1**까지의 값을 가지는 배열을 만드는 함수

## 4) np.reshape() : 내부 데이터를 변경하지 않고 배열의 구조를 수정하는 함수.

## 5) Numpy 슬라이싱 : 파이썬의 자료구조형(리스트나 배열)처럼 특정 연속되는 부분을 잘라서 출력하는 함수.

## 6) Numpy 정수 인덱싱(integer indexing) : 연속되지 않은 특정 부분 중 원하는 부분을 추출해서 하나의 배열로 만드는 함수.

## 7) Numpy 연산 : Numpy에서 배열 간 연산을 수행하는 방법에 대한 내용.
- ### np.add(x,y), x+y 와 동일
- np.subtract(x,y), x-y와 동일
- np.multiply(result * x), result * x
- np.divide(result, x), result/x

# 3. 맷플롯립(Matplotlib)
## 데이터를 차트나 플롯(plot)으로 시각화하는 패키지.

## 1) 라인 플롯 그리기

![[Pasted image 20241001230420.png]]

## 2) 축 레이블 삽입하기

![[Pasted image 20241001230451.png]]

## 3) 라인 추가와 범례 삽입하기

![[Pasted image 20241001230644.png]]