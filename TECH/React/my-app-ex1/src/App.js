import logo from "./logo.svg";
import "./App.css";
import Header from "./components/Header";
import Nav from "./components/Nav";
import Footer from "./components/Footer";
import Content from "./components/Content";

function App() {
  return (
    <div>
      <Header></Header>
      <Nav></Nav>
      <Content></Content>
      <Footer></Footer>
    </div>
  );
}

export default App;
