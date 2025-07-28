import styled from "styled-components";

const SimpleButton = styled.button`
  color: white;
  background-color: blue;
`;

const LargeButton = styled(SimpleButton)`
  font-size: 40px;
`;

export { SimpleButton, LargeButton };
