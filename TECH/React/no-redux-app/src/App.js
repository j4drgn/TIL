import "./App.css";
import Left1 from "./components/Left1";
import { useState } from "react";
import Right1 from "./components/Right1";

function App() {
  let [count, setCount] = useState(0);

  const onCountAdd = () => {
    setCount(count + 1);
  };

  const onCountMinus = () => {
    setCount(count - 1);
  };
  return (
    <div className="App">
      <h3>Root</h3>
      <div id="container">
        <Left1 count={count} />
        <Right1
          count={count}
          onCountAdd={onCountAdd}
          onCountMinus={onCountMinus}
        />
      </div>
    </div>
  );
}

export default App;
