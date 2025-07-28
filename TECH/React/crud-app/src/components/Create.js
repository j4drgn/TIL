import React from "react";

const Create = (props) => {
  return (
    <article>
      <h2>Create</h2>
      {/* submit 이벤트의 기본 기능은 중지시킴 */}
      <form
        onSubmit={(event) => {
          event.preventDefault();
          //submit 이벤트 발생시에 입력된 데이터 추출
          const title = event.target.title.value;
          const body = event.target.body.value;
          props.onCreate(title, body); //onCreate는 인수 2개가 필요함-입력된 값  title과 body
        }}
      >
        <p>
          <input type="text" name="title" placeholder="title" />
        </p>
        <p>
          <textarea name="body" placeholder="body" />
        </p>
        <p>
          <input type="submit" value="Create" />
        </p>
      </form>
    </article>
  );
};

export default Create;
