import React, { createContext, useContext } from "react";

//적용할 css 테마로 구성 - Context 생성
const themeDefault = { border: "10px solid red" };
const themeContext = createContext(themeDefault); //Context 생성, 전역으로 사용 가능
//Context 객체인 themeContext는 Provider 기능 사용 할 수 있음
export default function App() {
  // themeContext 사용
  const theme = useContext(themeContext);
  console.log(theme);
  return (
    <div className="root" style={theme}>
      <h1>Hello World!</h1>
      <Sub1 />
    </div>
  );
}

function Sub1() {
  const theme = useContext(themeContext);
  return (
    <themeContext.Provider value={{ border: "10px solid green" }}>
      <div style={theme}>
        <h1>Sub1</h1>
        <Sub2 />
      </div>
    </themeContext.Provider>
  );
}

function Sub2() {
  const theme = useContext(themeContext);
  return (
    <div style={theme}>
      <h1>Sub2</h1>
      <Sub3 />
    </div>
  );
}

function Sub3() {
  const theme = useContext(themeContext);
  return (
    <div style={theme}>
      <h1>Sub3</h1>
    </div>
  );
}
