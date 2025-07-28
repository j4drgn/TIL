import React from "react";

// const Subject = ({ title, sub }) => {
//   return (
//     <header>
//       <h1>{title}</h1>
//       <p>{sub}</p>
//     </header>
//   );
// };

const Subject = (props) => {
  Subject.defaultProps = {
    title: "기본제목",
    sub: "기본설명",
    content: "기본내용",
  };
  return (
    <header>
      <h1>{props.title}</h1>
      <p>{props.sub}</p>
      {props.content}
      <br />
    </header>
  );
};
export default Subject;
