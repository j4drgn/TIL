import React from "react";
import { Link } from "react-router-dom";

const Content = (props) => {
  const book_list = props.book_list;

  return (
    <div className="bookinfo">
      <h3>도서목록</h3>
      <table border="1">
        <tbody>
          <tr>
            <th>도서번호</th>
            <th>도서제목</th>
            <th>도서저자</th>
            <th>출판년도</th>
            <th>카테고리</th>
          </tr>
          {book_list.map((book) => {
            return (
              <tr key={book.id}>
                <td>{book.id}</td>
                {/* Link는 Content 컴포넌트에서 라우터 셋팅은 */}
                <td>
                  <Link to={`/Content/${book.id}`}>{book.title}</Link>
                </td>
                <td>{book.author}</td>
                <td>{book.year}</td>
                <td>{book.categories}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default Content;
