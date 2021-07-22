import React from 'react';
import "./login.css";

const Login = ({setLoggedIn}) => {

  const handleSubmit = (e) => {
    e.preventDefault();
    setLoggedIn(true);
  }

  return (
    <div className="pad">
        <form action = "http://localhost:5000/" method = "post" onSubmit={handleSubmit}>
            <div className="form-group">
                <label>User ID</label> <br/>
                <input placeholder="Enter userID"/><br/>
            </div>
            <div className="form-group">
                <label>Password</label> <br/>
                <input type="password" placeholder="Password"/><br/>
                <small id="emailHelp" className="form-text text-muted">We'll never share your password with anyone else.</small>
            </div>
            <div className="form-check">
                <input type="checkbox" className="form-check-input" id="exampleCheck1"/>
                <label className="form-check-label" htmlFor="exampleCheck1">Remember me</label>
            </div>
            <button type="submit" className="btn btn-primary">Submit</button>
        </form>
        <a href="/register">Register new user?</a>
    </div>
  );
}

  export default Login;