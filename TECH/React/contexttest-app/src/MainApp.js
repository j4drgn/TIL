import "./App.css";
import { createContext } from "react";
import { HookContextChild } from "./components/HookContextChild";

//컨텍스트 초기화
export const MyAppContext = createContext();

//컨텍스트에서 전달할 객체 준비
const config = {
  title: "React 프로젝트",
  lang: "ko-kr",
};

function MainApp() {
  return (
    <MyAppContext.Provider value={config}>
      <div id="c_main">
        <HookContextChild />
      </div>
    </MyAppContext.Provider>
  );
}

export default MainApp;
