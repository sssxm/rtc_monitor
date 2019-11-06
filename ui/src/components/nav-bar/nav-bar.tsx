import * as React from "react";
import "./nav-bar.css";

export interface NavBarProps {}

export interface NavBarState {}

class NavBar extends React.Component<NavBarProps, NavBarState> {
  state = {
    count: 0
  };

  render() {
    return (
      <div className="nav-bar-back">
        <span>{this.formatCount()}</span>
      </div>
    );
  }

  formatCount() {
    const { count } = this.state;
    return count === 0 ? <h1>Navbar Container</h1> : count;
  }
}

export default NavBar;
