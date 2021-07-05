import React from 'react';

class Login extends React.Component {
    render() {
      return (
        <div>
          <h1>Login </h1>
          <form>
            Username: <input></input><br/>
            Password: <input type="password"></input><br/>
          </form>
          <a href="/register">Register new user?</a>
        </div>
      );
    }
  }

  export default Login;