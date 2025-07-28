import styled from "styled-components";
import ReactButton from "./ReactButton";

// 일반 컴포넌트 상속 받아 새로운 styled 컴포넌트 생성
// ReactButton의 스타일 상속 받고 font-size 속성 추가
// 아래와 같이 상속 받으면 상속 받은 객체는 모두 표현됨.
// 아래 css가 추가되게 하려면 상속되는 컴포넌트에서 className(리엑트가 동적 생성함)을 포함시켜서 반환해야함.

export const ReactLargeButton = styled(ReactButton)`
  font-size: 50px;
`;
