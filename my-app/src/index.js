import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Switch , Route} from 'react-router-dom';
import './index.css';
import Login from "./login";
import Register from "./register";
import Home from "./home"

class App extends React.Component {
  render() {
    return (
      <BrowserRouter>
        <div>
          <h1>Banking System </h1>
          <div><a href="/git sta">Login</a></div>
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


