import React from 'react';
import "./login.css";

class Login extends React.Component {
    render() {
      return (
        <div className="pad">
            <form>
                <div class="form-group">
                    <label>User ID</label> <br/>
                    <input placeholder="Enter userID"/><br/>
                </div>
                <div class="form-group">
                    <label>Password</label> <br/>
                    <input type="password" placeholder="Password"/><br/>
                    <small id="emailHelp" class="form-text text-muted">We'll never share your password with anyone else.</small>
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1"/>
                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        /* <div>
          <h1>Login </h1>
          <form>
            Username: <input></input><br/>
            Password: <input type="password"></input><br/>
          </form>
          <a href="/register">Register new user?</a>
        </div> */
      );
    }
  }

  export default Login;