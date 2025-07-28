import logo from "./logo.svg";
import "./App.css";
import Subject from "./components/Subject";
import Content from "./components/Content";
import Nav2 from "./components/Nav2";

function Header() {
  return (
    <header>
      <h1>
        <a href="/">홈</a>
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
      </ol>
      <ol>
        <li>
          <a href="">html</a>
        </li>
      </ol>
      <ol>
        <li>
          <a href="">html</a>
        </li>
      </ol>
    </nav>
  );
}

function Article() {
  return (
    <article>
      <h2>Welcome</h2>
      Hello, WEB
    </article>
  );
}

function App() {
  return (
    <div className="App">
      <Header></Header>
      <Nav></Nav>
      <Article></Article>
      <Subject></Subject>
      <Content></Content>
      <Nav2></Nav2>
    </div>
  );
}

export default App;
