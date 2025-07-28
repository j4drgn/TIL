import React from "react";
import { useParams } from "react-router-dom";

const Book = (props) => {
  let params = useParams();
  let bookid = params.book_id;

  let result = props.onFind(bookid);

  return (
    <div>
      <hr />
      {/* 도서 1권에 대한 정보   app 컴포넌트에서 book 컴포넌트 접근할때 도서 한권 정보 */}
      <p>도서번호 : {result.id}</p>
      <p>도서제목 : {result.title}</p>
      <p>도서저자 : {result.author}</p>
      <p>출판년도 : {result.year}</p>
      <p>카테고리 : {result.categories}</p>
    </div>
  );
};

export default Book;
