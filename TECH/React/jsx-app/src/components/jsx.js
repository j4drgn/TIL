import React from "react";
const jsx = () => {
  //자바스크립트 코드
  const name = "홍길동"; //상수 name 선언 및 생성
  const number = 0;
  const num = 3;
  //내부함수, 사용자정의 객체 선언
  //객체 선언
  const person = {
    name: "성춘향",
    age: 20,
  };
  //내부함수 정의
  function getPerson() {
    return person.name + ", " + person.age;
  }
  return (
    <div>
      <h1>JSX입니다</h1>
      <h2>name 안녕!</h2> {/** 문자열  name */}
      <h2>{name} 안녕!!</h2>
      {/** 스크립트영역{}이므로 상수 name접근  */}
      {number || "오리"}
      {number && "오리"}
      {false && "오리"}
      {
        //조건 연산자 사용 조건에 따라 실행할 문장이 두문장 이상이면 반드시 소괄호로 묶어야 함
        name == "홍길동" ? <h3>홍길동 입니다</h3> : <h3>홍길동이 아닙니다</h3>
      }
      {name == "이몽룡" ? <h3>이몽룡입니다</h3> : <h3>이몽룡이 아닙니다</h3>}
      <div
        style={{
          margin: "0 auto",
          width: "50%",
          backgroundColor: "red",
          color: "white",
          fontSize: "36px",
          fontWeight: "bold",
          padding: 10,
          marginTop: "20px",
        }}
      >
        인라인 스타일링 적용
      </div>
      <div className="rect">className 속성 사용</div>
      주소 : 서울 <br /> {/** 단일 태그도 닫는 표시 />를 사용해야 함 */}
      //JSX 주석은 아님(자바스크립트 주석) <br />
      /* 주석아님 문자열 처리 됨*/ <br />
      {/**주석은 이렇게 */}
      {/* ctrl + / 주석표시 자동 완성 */}
      {
        //자바스크립트 영역 - 자동호출되는 함수
        (function () {
          if (num == 1) return <div>value=1</div>;
          if (num == 2) return <div>value=2</div>;
          if (num == 3) return <div>value=3</div>;
        })()
      }
      <div>getPerson()</div>
      <div>{getPerson()}</div>
    </div>
  );
};
export default jsx;
