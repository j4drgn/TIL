import React from "react";
//일반 객체 버튼

const ReactButton = (props) => {
  const style = {
    color: "white",
    backgroundColor: "blue",
  };
  return (
    <div>
      {/* 객체 생성시 className은 자동 구성됨 필요하면 props를 이용해서 사용할수 있음 */}
      <button style={style} className={props.className}>
        {props.children}
      </button>
    </div>
  );
};

export default ReactButton;
