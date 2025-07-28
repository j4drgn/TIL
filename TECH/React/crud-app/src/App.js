import "./App.css";
import { useState } from "react";
import Create from "./components/Create";
import Update from "./components/Update";

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
            props.onChangeMode(Number(event.target.id));
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
  const [mode, setMode] = useState("WELCOME");
  const [id, setId] = useState(null);

  //topics가 값이 변경되면 (원소가 추가되면) 표현된 화면의 목록이 변경되어야 함 ->렌더링이 진행되어야 함
  //state 활용
  const [nextId, setNextId] = useState(4);

  const [topics, setTopics] = useState([
    { id: 1, title: "html", body: "html is ..." },
    { id: 2, title: "css", body: "css is ..." },
    { id: 3, title: "javascript", body: "javascript is ..." },
  ]);

  // mode값에 따라 content 변환 코드
  let content = null;
  let contextControl = null;

  if (mode === "WELCOME") {
    //초기화면
    content = <Article title="Welcome" body="Hello, Web"></Article>;
  } else if (mode === "READ") {
    //게시 목록을 클릭하면 변화되는 코드
    let title,
      body = null;
    for (let i = 0; i < topics.length; i++) {
      console.log(topics[i].id, id);
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;
    // contextControl 객체 변수에 두개의 태그를 담아서 표현 -> 화면에 표현되는 태그 추가
    // JSX 최상위 태그가 반드시 있어야함.
    // 의미 없는 태그를 활용해서 최상위 태그 구성 가능함. <></>

    contextControl = (
      <>
        <li>
          <a
            href={"/update/" + id}
            onClick={(event) => {
              event.preventDefault();
              setMode("UPDATE");
            }}
          >
            Update
          </a>
        </li>
        <li>
          <input
            type="button"
            value="Delete"
            onClick={() => {
              // delete는 화면 표현 변화가 필요 없으므로 버튼 클릭 이벤트에서 코드 진행
              // 새로운 배열 객체 생성하고 생성된 객체에 delete에 해당하는 id data를 제외한 나머지 data만 추가함.
              const newTopics = [];
              for (let i = 0; i < topics.length; i++) {
                if (topics[i].id !== id) {
                  newTopics.push(topics[i]);
                }
              }
              setTopics(newTopics);
              setMode("WELCOME");
            }}
          ></input>
          Delete
        </li>
      </>
    );
  } else if (mode === "CREATE") {
    //create 메뉴 클릭하면 입력창을 표현(component 이용->Create)
    // Create 컴포넌트의 create 버튼을 클릭해서 submit 이벤트가 발생하면 props로 전달된 함수가 실행이 되도록
    // 함수 내용은 입력된 title과 body를 위에서 선언한 topics 배열에 추가
    content = (
      <Create
        onCreate={(_title, _body) => {
          const newTopic = { id: nextId, title: _title, body: _body }; //submit 이벤트 발생시 전달되는 인수를 사용자 정의 객체로 구성
          const newTopics = [...topics]; //state value 객체배열 복사 -> 원본 보존
          newTopics.push(newTopic);
          setTopics(newTopics);
          setMode("READ");
          setId(nextId);
          setNextId(nextId + 1);

          //topics.push(newTopic);
          //setTopics(topics); //기존 state value객체인 topics하고 setTopics가 전달하고 값하고 비교해서 변경된것이 있어야 렌더링을 진행함
          //위 코드는 state가 참조하는 배열을 미리 변경시켜 놓고 변경된 배열을 setTopics에게 전달했음 setTopics입장에서는 변화가 없음
          //렌더링 진행안됨 -> state가 참조하는 원본 배열을 복사해서 복사본을 변경함->setTopics에게 복사본전달 -> 원본과 비교해서 변동이 있으므로
          //렌더링 진행하고 원본을 변경시킴
          //배열 복제 : [...배열명]
        }}
      ></Create>
    );
  } else if (mode === "UPDATE") {
    let title,
      body = null;
    for (let i = 0; i < topics.length; i++) {
      console.log(topics[i].id, id);
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = (
      <Update
        title={title}
        body={body}
        onUpdate={(title, body) => {
          const newTopics = [...topics];
          const updateTopic = { id: id, title: title, body: body };

          for (let i = 0; i < newTopics.length; i++) {
            if (newTopics[i].id === id) {
              newTopics[i] = updateTopic;
              break;
            }
          }
          setTopics(newTopics);
          setMode("READ");
        }}
      ></Update>
    );
  }

  return (
    <div className="App">
      <Header
        title="WEB"
        onChangeMode={() => {
          setMode("WELCOME");
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(_id) => {
          setMode("READ");
          setId(_id);
        }}
      ></Nav>
      {content}
      <ul>
        <li>
          <a
            href="/create"
            onClick={(event) => {
              event.preventDefault();
              setMode("CREATE");
            }}
          >
            Create
          </a>
        </li>
        {contextControl}
      </ul>
    </div>
  );
}

export default App;
