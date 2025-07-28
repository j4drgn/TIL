import React from "react";
import { Routes, Route, NavLink, useParams } from "react-router-dom";
import Topic from "./Topic";

const Topics = (props) => {
  // var params = useParams();
  // console.log(params);
  let contents = props.contents;
  var lis = [];
  for (var i = 0; i < contents.length; i++) {
    lis.push(
      <li key={contents[i].id}>
        <NavLink to={"/topics/" + contents[i].id}>{contents[i].title}</NavLink>
      </li>
    );
  }
  return (
    <div>
      <h2>Topics</h2>
      {/* 아래 목록은 정적태그임 반드시 3개 목록이 생성됨 데이터에 따라 다른 목록을 표현하려고 하면 동적 태그 구성 
            <ul>
                <li><NavLink to="/topics/1">Politics</NavLink></li>
                <li><NavLink to="/topics/2">Economy</NavLink></li>
                <li><NavLink to="/topics/3">Society</NavLink></li>
            </ul>   */}

      <ul>{lis}</ul>

      <Routes>
        {/* 이 라우터에서는 App애서 매핑된 /topics는 제외시키고 하위 url만 매핑하면 됨 */}
        {/* <Route path="/1" element={"Politics is ..."}></Route>
                <Route path="/2" element={"Economy is ..."}></Route>
                <Route path="/3" element={"Society is ..."}></Route>                 */}
        <Route path="/:topic_id" element={<Topic content={contents} />}></Route>
      </Routes>
    </div>
  );
};

export default Topics;
