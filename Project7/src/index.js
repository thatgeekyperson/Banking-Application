import ReactDOM from 'react-dom';
import { BrowserRouter, Switch , Route} from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import './index.css';
import Login from "./login";
import Register from "./register";
import Home from "./home"
import LoanForm from './loanform';
import NavBar from "./navbar"
import ClientStatus from './clientstatus';
import 'bootstrap/dist/css/bootstrap.min.css';
// import background from "./img_financedoodle.jpg";


function App() {

  const [logged_in, setLoggedIn] = useState(true);

  // useEffect(() => {
  //   fetch('http://localhost:5000/login').then(res => res).then(data => {
  //     setLoggedIn(data.logged_in);
  //   });
  // }, []);

  return (
    <BrowserRouter>
      <div>

        <NavBar showHide={logged_in}/>

        <Switch>
          <Route exact path="/">
            <Home/>
          </Route>
          <Route exact path="/login">
            <Login/>
          </Route>
          <Route exact path="/register">
            <Register/>
          </Route>
          <Route exact path="/loanform">
            <LoanForm/>
          </Route>
          <Route exact path="/clientstatus">
            <ClientStatus/>
          </Route>
        </Switch>
      </div>
    </BrowserRouter>
  );

}

// ========================================

ReactDOM.render(
  <App />,
  document.getElementById('root')
);


