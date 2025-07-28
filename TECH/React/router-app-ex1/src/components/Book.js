import React from "react";
import { useParams, Link } from "react-router-dom";

const Book = ({ book }) => {
  const { keyword } = useParams();
  const selectedBook = book.find((b) => b.id === parseInt(keyword));

  return (
    <div>
      <h2>도서 상세 정보</h2>
      {selectedBook ? (
        <div>
          <h3>{selectedBook.title}</h3>
          <p>저자: {selectedBook.author}</p>
          <p>가격: {selectedBook.price}</p>
          <p>설명: {selectedBook.description}</p>
          <Link to="/content">목록으로 돌아가기</Link>
        </div>
      ) : (
        <p>해당 ID의 도서를 찾을 수 없습니다.</p>
      )}
    </div>
  );
};

export default Book;
