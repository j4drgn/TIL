## 1. Pandas
### Pandas란? 파이썬 데이터 처리를 위한 라이브러리
### Pandas는 총 세 가지의 데이터 구조를 사용
### - 시리즈(Series)
### - 데이터프레임(DataFrame)
### - 패널(Panel)
### 이 중 데이터 프레임이 가장 많이 사용된다.

## 1) 시리즈(Series)
### 시리즈 클래스는 1차원 배열의 값(Values)에 각 값에 대응되는 인덱스(index)를 부여할 수 있는 구조

```pytorch
sr = pd.Series([17000, 18000, 1000, 5000], index=["피자", "치킨", "콜라", "맥주"])
print('시리즈 출력 :')
print('-'*15)
print(sr)

# 출력값
시리즈 출력 :
---------------
피자    17000
치킨    18000
콜라     1000
맥주     5000
dtype: int64
```

### 값(values)과 인덱스(index)를 출력

```pytorch
print('시리즈의 값 : {}'.format(sr.values))
print('시리즈의 인덱스 : {}'.format(sr.index))

# 출력값
시리즈의 값 : [17000 18000  1000  5000]
시리즈의 인덱스 : Index(['피자', '치킨', '콜라', '맥주'], dtype='object')
```