import React from "react";

function Student(props) {
  return (
    <div className="student">
      <h2>학생 정보</h2>
      {props.students &&
        props.students.map((student, index) => (
          <div key={index}>
            <p>이름: {student.name}</p>
            <p>나이: {student.age}</p>
            <p>학년: {student.year}</p>
            <p>주소: {student.address}</p>
          </div>
        ))}
    </div>
  );
}

export default Student;
