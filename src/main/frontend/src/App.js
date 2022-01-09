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
import QuizTab from './components/QuizTab';

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
          <li>
            <Link to="/Quiz">Quiz</Link>
          </li>
        </ul>

        <hr />

        <Routes>
          <Route exact path="/" element={<CreateTab />}/>
          <Route exact path="/FactionTab" element={<Dashboard />}/>
          <Route exact path="/Quiz" element={<QuizTab />}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
