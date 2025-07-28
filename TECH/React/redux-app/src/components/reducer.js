import React from "react";

const reducer = (currentState, action) => {
  //currentState가 정의 되지 않은 경우 기본 state 값 반환
  if (currentState === undefined) {
    return { count: 0 };
  }
  // 각 State의 불변성 유지하기 위해 state 복제해서 사용
  const newState = { ...currentState };

  //여기서 state값 변경
  if (action.type === "add") {
    newState.count++;
  }
  if (action.type === "minus") {
    if (newState.count > 0) {
      newState.count--;
    }
  }
  //변화시킨 값을 반환
  return newState;
};

export default reducer;
