import "./App.css";
import { Link, Routes, Route } from "react-router-dom";
import Home from "./components/Home";
import Content from "./components/Content";
import Book from "./components/Book";

function App() {
  const book = [
    {
      id: 1,
      title: "생활 코딩! React 리액트 프로그래밍",
      author: "이고잉",
      price: "22,500원",
      description:
        "처음 프로그래밍을 시작하는 입문자의 눈높이에 맞춘 저자 직강 동영상 강의 제공 (위키북스 러닝스쿨 시리즈 11)",
    },
    {
      id: 2,
      title: "모던 리액트 Deep Dive",
      author: "김용찬",
      price: "43,200원",
      description:
        "리액트의 핵심 개념과 동작 원리부터 Next.js까지, 리액트의 모든 것 (위키북스 프로그래밍 & 프랙티스 시리즈 35)",
    },
    {
      id: 3,
      title: "우아한 타입스크립트 with 리액트",
      author: "우아한 형제들",
      price: "28,800원",
      description:
        "배달의민족 개발 사례로 살펴보는 우아한형제들의 타입스크립트와 리액트 활용",
    },
  ];

  return (
    <div>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/content">Content</Link>
        </li>
      </ul>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/content" element={<Content book={book} />} />
        <Route path="/book/:keyword" element={<Book book={book} />} />
      </Routes>
    </div>
  );
}

export default App;
