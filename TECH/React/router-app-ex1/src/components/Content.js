import React from "react";
import { Link } from "react-router-dom";

function Content({ book }) {
  return (
    <div>
      <h2>콘텐츠 페이지</h2>
      <p>전체 도서 정보 출력 페이지입니다.</p>

      <div className="all-books">
        {book.map((item) => (
          <div key={item.id} className="book-detail">
            <h3>{item.title}</h3>
            <p>저자: {item.author}</p>
            <p>가격: {item.price}</p>
            <p>설명: {item.description}</p>
            <Link to={`/book/${item.id}`}>상세 보기</Link>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Content;
