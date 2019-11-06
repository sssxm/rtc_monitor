import React from "react";
import logo from "./logo.svg";
import "./App.css";
import NavBar from "./components/nav-bar/nav-bar";
import GridContainer from "./components/grid-container/grid-container";
import { BandwidthProvider } from "@bandwidth/shared-components";
import { Button } from "@bandwidth/shared-components";

class Homepage extends React.Component {
  render() {
    return (
      <BandwidthProvider>
        <div className="App">
          <NavBar> </NavBar>
          <Button>Test Button</Button>
          <div className="grid_container">
            <GridContainer></GridContainer>
          </div>
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <p>
              Edit <code>src/App.tsx</code> and save to reload.
            </p>
            
          </header>
        </div>
      </BandwidthProvider>
    );
  }
}
export default Homepage;
