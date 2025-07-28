import React, { useState } from "react";

const Update = (props) => {
  const [title, setTitle] = useState(props.title);
  const [body, setBody] = useState(props.body);
  return (
    <article>
      <h2>Update</h2>
      {/* submit 이벤트의 기본 기능은 중지시킴 */}
      <form
        onSubmit={(event) => {
          event.preventDefault();
          //submit 이벤트 발생시에 입력된 데이터 추출
          const title = event.target.title.value;
          const body = event.target.body.value;
          props.onUpdate(title, body); //onCreate는 인수 2개가 필요함-입력된 값  title과 body
        }}
      >
        <p>
          <input
            type="text"
            name="title"
            placeholder="title"
            value={title}
            onChange={(event) => {
              setTitle(event.target.value);
            }}
          />
        </p>
        <p>
          <textarea
            name="body"
            placeholder="body"
            value={body}
            onChange={(event) => {
              setBody(event.target.value);
            }}
          />
        </p>
        <p>
          <input type="submit" value="Update" />
        </p>
        {/* value값은 특정값으로 고정한 상태 inputbox 수정 안됨 state 이용해서 관리 */}
        {/* <p><input type="text" name="title" placeholder='title' value={props.title}/></p>
                <p><textarea name='body' placeholder='body' value={props.body}/></p>
                <p><input type='submit' value='Update'/></p> */}
      </form>
    </article>
  );
};

export default Update;
