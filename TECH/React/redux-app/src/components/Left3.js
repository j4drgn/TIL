import React from "react";
import { useSelector } from "react-redux";

const Left3 = () => {
  // store에 접근해서 state value인 count 값을 출력
  // useSelector() 사용해서 store의 state에 접근 가능
  // 아래 코드가 최초 실행되는  시점은 currentState가 undefined이면,
  // reducer의 if문이 실행되면 0이 반환되고 currentState가 0으로 초기화됨
  
  // 두번째
  const count = useSelector((state) => state.count);
  return (
    <div>
      <h3>Left3</h3>
      count: {count}
    </div>
  );
};

export default Left3;
