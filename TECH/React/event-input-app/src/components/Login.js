import { React, useState } from "react";

const Login = () => {
  const [id, setId] = useState("");
  const [password, setPassword] = useState("");

  const idChange = (event) => setId(event.target.value);
  const pwdChange = (event) => setPassword(event.target.value);

  const login = () => {
    alert(
      id === "abcd" && password === "1234" ? "로그인 성공!" : "로그인 실패!"
    );
  };

  return (
    <div>
      <h2>로그인</h2>
      <input type="text" value={id} onChange={idChange} placeholder="아이디" />
      <br />
      <input
        type="password"
        value={password}
        onChange={pwdChange}
        placeholder="비밀번호"
      />
      <br />
      <button onClick={login}>로그인</button>
    </div>
  );
};

export default Login;
