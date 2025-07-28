import React, { useState } from "react";
const Message = () => {
  const [message, setMessage] = useState("출력 메시지"); //message 값 변화 상태 관리, 값변화시 다시 렌더링 진행
  return (
    <div>
      <h3>{message}</h3>
    </div>
  );
};
export default Message;
