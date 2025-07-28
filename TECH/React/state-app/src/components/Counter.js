import React, { useState } from "react";

const Counter = () => {
  const [count, setCount] = useState(0);

  const onClickMinus = () => {
    //state의 setter함수가 호출되어도 value값이 변화가 없으면 렌더링 진행되지않음.
    count > 0 ? setCount(count - 1) : setCount(0);
  };
  const onClickPlus = () => {
    setCount(count + 1); //count 값 변경 -> 컴포넌트 랜더링 다시 진행
  };
  return (
    <div>
      <hr />
      <h3>{count}</h3>
      <button onClick={onClickMinus}>-</button> &nbsp;
      <button onClick={onClickPlus}>+</button>
    </div>
  );
};

export default Counter;
