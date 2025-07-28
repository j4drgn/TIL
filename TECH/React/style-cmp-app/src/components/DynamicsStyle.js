import styled from "styled-components";

export const PrimaryButton = styled.button`
  color: ${(props) => (props.primary ? "white" : "black")};

  background-color: ${(props) => (props.primary ? "red" : "gray")};
`;

//   color: ${function (props) {
//     console.log(props);
//     if (props.primary) {
//       return "red";
//     } else {
//       return "black";
//     }
//   }};
// `;
