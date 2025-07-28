import imgblack from "./image/black.png";
import "./App.css";
import Subject from "./components/Subject";
// import 명을 수정해서 import하면 내부 컴포넌트와 충돌나지 않음
import Nav2 from "./components/Nav";
import Student from "./components/Student";

function Header(props) {
  // 컴포넌트에 매개변수 설정하면 컴포넌트를 사용하는 쪽에서 속성으로 전달된 객체를 받을 수 있음
  console.log(props);
  console.log(props.age);
  console.log(props.title);
  return (
    <header>
      <h1>
        <a href="/">{props.title}</a>
      </h1>
    </header>
  );
}

function Nav() {
  return (
    <nav>
      <ol>
        <li>
          <a href="">html</a>
        </li>
        <li>
          <a href="">css</a>
        </li>
        <li>
          <a href="">js</a>
        </li>
      </ol>
    </nav>
  );
}

function Article() {
  return (
    <article>
      <h2>welcome</h2>
      Hello, Web
    </article>
  );
}

function App() {
  const title = "props연습";
  let content = "내용";
  const topics = [
    { id: 1, title: "html", body: "html is ..." },
    { id: 2, title: "css", body: "css is ..." },
    { id: 3, title: "javascript", body: "javascript is ..." },
  ];

  /* 주로 전달되는 json형태
  const topics2 = { 
    res : [
      {id:1, title:'html', body:'html is ...'},
      {id:2, title:'css', body:'css is ...'},
      {id:3, title:'javascript', body:'javascript is ...'}
    ]
  };
  */

  const students = [{ name: "홍길동", age: 20, year: 4, address: "서울" }];

  return (
    <div className="App">
      {/* 사용자 정의 태그에 속성에 값을 준다면? */}
      <Header title="리액트" age="20"></Header> <Nav />
      <Article />
      {/* 속성=값 속성=값 형태로 여러개의 값 전달 가능 */}
      <Subject title={title} sub="부제목" content={content}></Subject>
      {/* 속성 전달이 없으면 오류는 없는 상태에서 아무것도 안뜸 */}
      <Subject></Subject>
      <Nav2 topics={topics}></Nav2>
      {/* 이미지 경로 import해서 사용 */}
      <img src={imgblack} alt="black" width="100" height="100" />
      <Student students={students}></Student>
      {/* onChangeMode라는 속성에 value로 함수를 전달 */}
      <Header
        title="WEB"
        onChangeMode={function () {
          alert("Header");
        }}
      ></Header>
    </div>
  );
}

export default App;
