import React from "react";
import { useDispatch } from "react-redux";

const Right3 = () => {
  const dispatch = useDispatch();

  return (
    //store에 접근해서 state 값을 변경시키는 기능을 수행(action)
    //action은 useDispatch() 활용해서 store에 의견 전달 가능

    <div>
      <h3>Right3</h3>
      <button onClick={() => dispatch({ type: "minus" })}>-</button>&nbsp;
      <button onClick={() => dispatch({ type: "add" })}>+</button>
    </div>
  );
};

export default Right3;
