import React from "react";
import Left2 from "./Left2";

const Left1 = (props) => {
  return (
    <div>
      <h3>Left1</h3>
      <Left2 count={props.count} />
    </div>
  );
};

export default Left1;
