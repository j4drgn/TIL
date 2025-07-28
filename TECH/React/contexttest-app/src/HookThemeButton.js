import { useContext } from "react";
import { Button } from "@mui/material";
import ThemeContext from "./components/ThemeContext";

export default function HookThemeButton() {
  const { mode, toggleMode } = useContext(ThemeContext);
  return (
    <Button variant="contained" onClick={toggleMode}>
      Mode {mode}
    </Button>
  );
}
