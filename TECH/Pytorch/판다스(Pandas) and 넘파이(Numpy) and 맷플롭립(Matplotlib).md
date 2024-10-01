## 1. Pandas
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

![[Pasted image 20241001222300.png]]
