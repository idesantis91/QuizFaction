import './App.css';
import React from 'react';
import CreateTab from './components/CreateTab';
import Dashboard from './components/Dashboard';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";

function App() {

  return (
    <Router>
      <div>
        <ul>
          <li>
            <Link to="/">Create Account</Link>
          </li>
          <li>
            <Link to="/FactionTab">Faction</Link>
          </li>
        </ul>

        <hr />

        <Routes>
          <Route exact path="/" element={<CreateTab />}/>
          <Route exact path="/FactionTab" element={<Dashboard />}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
