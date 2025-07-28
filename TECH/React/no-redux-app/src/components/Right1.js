import React from "react";
import Right2 from "./Right2";

const Right1 = (props) => {
  return (
    <div>
      <h3>Right1</h3>
      <Right2
        count={props.count}
        onCountAdd={props.onCountAdd}
        onCountMinus={props.onCountMinus}
      />
    </div>
  );
};

export default Right1;
