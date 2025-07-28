import "./App.css";
import Left1 from "./components/Left1";
import Right1 from "./components/Right1";

function App() {
  return (
    <div className="App">
      <h3>Root</h3>
      <div id="container">
        <Left1 />
        <Right1 />
      </div>
    </div>
  );
}

export default App;
