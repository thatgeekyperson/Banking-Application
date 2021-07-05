import React from 'react';

class Login extends React.Component {
    render() {
      return (
        <div>
          <h1>Home </h1>
          <p> This is home for loan prediction app.</p>
          <a href="/login">Login now</a> <br/>
          <a href="/register">Register new user?</a>
        </div>
      );
    }
  }

  export default Login;