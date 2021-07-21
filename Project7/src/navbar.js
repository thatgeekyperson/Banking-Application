import React from 'react';

function NavBar() {

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <a className="navbar-brand" href="/">Banking System</a>
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item active">
              <a className="nav-link" href="/">Home <span className="sr-only">(current)</span></a>
            </li>
            {
              // !this.props.showHide && 
              <li className="nav-item">
                <a className="nav-link" href="/login">Login</a>
              </li>
            }
            {
              // this.props.showHide &&
              <li className="nav-item">
                <a className="nav-link" href="/loanform">Loan Application Form</a>
              </li>
            }
            {
              // this.props.showHide &&
              <li className="nav-item">
               <a className="nav-link" href="/clientstatus">Client Status</a>
              </li>
            }
            {
              // this.props.showHide &&
              <li className="nav-item">
                <a className="nav-link" href="http://localhost:5000/flask_logout">Logout</a>
              </li>
            }

          </ul>
        </div>
      </nav>
    </div>
  );
  }

  export default NavBar;