import "../App.css";
import { React, useState } from "react";

const Contents = () => {
  const [titles, setTitle] = useState(["지금 우리 학교는", "오징어 게임"]);

  let [item, setItem] = useState("");

  const onItemChange = (e) => {
    setItem(e.target.value);
  };

  const onItemAdd = () => {
    if (item === "") {
      alert("내용을 입력해주세요");
      document.getElementById("titleInput").focus();
    } else if (titles.includes(item)) {
      //includes는 배열에 특정 값이 있는지 확인하는 메서드
      alert("이미 존재하는 내용입니다.");
      setItem("");
      document.getElementById("titleInput").focus();
    } else {
      // setTitle(titles.concat(item));
      setTitle([...titles, item]);
      // ...은 자바스크립트의 스프레드 연산자 객체나 배열복제할때 사용[...기존배열 , 새로운 항목]
      setItem("");
    }
  };

  // 원소값이 title과 동일하면 제외시키고 동일하지 않은 원소만 이용 새로운 배열 반환
  const onItemDelete = (title, index) => {
    setTitle(titles.filter((index) => titles[index] !== title));
  };

  return (
    <div>
      <div className="header">
        <h3>인기컨텐츠</h3>
      </div>

      <div className="content">
        {titles.map((title, index) => (
          <div key={index}>
            <p>
              {index + 1} : {title}
            </p>
            <button onClick={() => onItemDelete(title, index)}>삭제</button>
            <hr />
          </div>
        ))}

        <input
          type="text"
          id="titleInput"
          value={item}
          onChange={onItemChange}
        />

        <button onClick={onItemAdd}>추가</button>
      </div>
      {/* <div>
        <p>{title[0]}</p>
        <hr />
      </div>
      <div>
        <p>{title[1]}</p>
        <hr />
      </div> */}
    </div>
  );
};

export default Contents;
