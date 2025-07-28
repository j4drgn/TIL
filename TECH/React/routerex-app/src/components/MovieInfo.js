import React from "react";
import { Link } from "react-router-dom";

const MovieInfo = ({ movie }) => {
  return (
    <div>
      <hr />
      <h2>영화 정보</h2>
      <table border="1">
        <tbody>
          <tr>
            <th>제목</th>
            <th>감독</th>
            <th>배우</th>
            <th>개봉일</th>
            <th>장르</th>
          </tr>
          {movie.map((movie_ar) => (
            <tr>
              <td>
                <Link to={`/movieDetail/${movie_ar.id}`}>{movie_ar.title}</Link>
              </td>
              <td>{movie_ar.director}</td>
              <td>{movie_ar.actor}</td>
              <td>{movie_ar.year}</td>
              <td>{movie_ar.genre}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default MovieInfo;
