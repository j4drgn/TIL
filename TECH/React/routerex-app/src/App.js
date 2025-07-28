import "./App.css";
import About from "./components/About";
import Home from "./components/Home";
import MovieInfo from "./components/MovieInfo";
import MovieDetail from "./components/MovieDetail";
import { Routes, Route, Link } from "react-router-dom";

const movie = [
  {
    id: 1,
    title: "스파이더맨 노 웨이 홈",
    director: "존 왓츠",
    actor: "톰 홀랜드",
    year: "2021-12-15",
    genre: "액션",
  },
  {
    id: 2,
    title: "킹스맨 : 퍼스트 에이전트",
    director: "매튜 본",
    actor: "팔프 파인즈",
    year: "2021-12-22",
    genre: "액션",
  },
];

function App() {
  return (
    <div className="wrap">
      <div className="menu">
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
          <li>
            <Link to="/movieInfo">MovieInfo</Link>
          </li>
          {/* <li>
            <Link to="/movieDetail/spider">MovieDetail1</Link>
          </li>
          <li>
            <Link to="/movieDetail/king">MovieDetail2</Link>
          </li>
          <li>
            <Link to="/movieDetail/spider">MovieDetail3</Link>
          </li> */}
          <li>
            <a
              href="http://movie.naver.com"
              target="_blank"
              rel="noopener noreferrer"
            >
              네이버 영화
            </a>
          </li>
        </ul>
      </div>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/movieInfo" element={<MovieInfo movie={movie} />} />
        <Route
          path="/movieDetail/:keyword"
          element={<MovieDetail movie={movie} />}
        />
      </Routes>
    </div>
  );
}

export default App;
