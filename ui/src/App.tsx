import React from "react";
import "./App.css";
import Homepage from "./homepage";
import { BrowserRouter as Router, Route } from 'react-router-dom';

const App: React.FC = () => {
  return (
    <Router>
        <div>
            <Route path="/" component={Homepage}/>
        </div>
    </Router>
);
  
};

export default App;
