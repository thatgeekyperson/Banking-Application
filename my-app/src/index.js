import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Switch , Route} from 'react-router-dom';
import './index.css';
import Login from "./login";
import Register from "./register";
import Home from "./home"
import LoanForm from './loanform';

class App extends React.Component {
  render() {
    return (
      <BrowserRouter>
        <div>
          <h1>Banking System </h1>
          <div><a href="/login">Login</a> <br/>
          <a href="/loanform">Loan Application Form</a></div>
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
            </Switch>
        </div>
      </BrowserRouter>
    );
  }
}

// ========================================

ReactDOM.render(
  <App />,
  document.getElementById('root')
);


