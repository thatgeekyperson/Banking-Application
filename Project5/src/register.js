import React from 'react';

class Register extends React.Component {
    render() {
      return (
        <div>
          <h1>Register </h1>
          <form>
            Username: <input></input><br/>
            Password: <input type="password"></input><br/>
          </form>
          <a href="/login">Already a user?</a>
        </div>
      );
    }
  }

  export default Register;