import logo from "./logo.svg";
import "./App.css";
import { useState } from "react"; //useState 기능 포함
function Header(props) {
  console.log("props", props.title);
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode();
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}
function Nav(props) {
  const lis = [];
  for (let i = 0; i < props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(
      <li key={t.id}>
        <a
          id={t.id}
          href={"/read/" + t.id}
          onClick={(event) => {
            event.preventDefault();
            props.onChangeMode(event.target.id);
          }}
        >
          {t.title}
        </a>
      </li>
    );
  }
  return (
    <nav>
      <ol>{lis}</ol>
    </nav>
  );
}
function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  );
}
function App() {
  //let mode = 'WELCOME';
  //const _mode = useState('WELCOME'); //배열 반환, 길이가 2인 배열 반환 첫번째 원소 설정값, 두번째 원소 f()
  //console.log('_mode : ', _mode);
  //const mode = _mode[0] ; //상태값
  //const setMode = _mode[1]; //setMode는 상태변경 함수
  //일반적으로 useState 사용 형식
  const [mode, setMode] = useState("WELCOME");
  const topics = [
    { id: 1, title: "html", body: "html is ..." },
    { id: 2, title: "css", body: "css is ..." },
    { id: 3, title: "javascript", body: "javascript is ..." },
  ];
  let content = null;
  if (mode === "WELCOME") {
    content = <Article title="Welcome" body="Hello, Web"></Article>;
  } else if (mode === "READ") {
    content = <Article title="Read" body="Hello, Read"></Article>;
  }
  return (
    <div className="App">
      {/* 컴포넌트의 클릭 이벤트에 의해 mode 변수의 값은 변경됨
          content가 반영되려면 App 컴포넌트가 다시 렌더링 되어야 함
          mode값을 바꾸면 App을 호출(랜더링)되어야 함
          변수의 변화나 상태 변화가 생길 때 App호출(랜더링) 진행할 수 있도록
          state 기능 제공
      */}
      <Header
        title="WEB"
        onChangeMode={() => {
          // mode = "WELCOME";
          setMode("WELCOME"); //state객체 값 변경->컴포넌트 랜더링 다시 진행
          //console.log(mode);
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(id) => {
          // mode = "READ";
          setMode("READ"); //state객체 값 변경 -> 컴포넌트 랜더링 다시 진행
          //console.log(mode);
        }}
      ></Nav>
      {content}
    </div>
  );
}

export default App;
