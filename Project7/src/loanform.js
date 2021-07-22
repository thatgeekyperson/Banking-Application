import React from 'react';
import "./loanform.css"

class LoanForm extends React.Component {
    render() {
      return (
        <div className="pad">
          <h1>Loan Applicant Details </h1>
          <br/>
          <form action = "http://localhost:5000/loanform" method = "POST">
            <div className="input-group mb-3">
              Gender:  
              <select className="internalpadding" id="inputGroupSelect01" Name="gender">
                <option selected>Choose...</option>
                <option value="0">Male</option>
                <option value="1">Female</option>
              </select>
            </div>
            <div className="input-group mb-3">
              Married:  
              <select className="custom-select internalpadding" id="inputGroupSelect01" Name="married">
                <option selected>Choose...</option>
                <option value="1">Yes</option>
                <option value="0">No</option>
              </select>
            </div>
            <div className="input-group mb-3">
              Self Employed:  
              <select className="custom-select internalpadding" id="inputGroupSelect02" Name="self_employed">
                <option selected>Choose...</option>
                <option value="1">Yes</option>
                <option value="0">No</option>
              </select>
            </div>
            <div className="input-group mb-3">
              Credit History:  
              <select className="custom-select internalpadding" id="inputGroupSelect03" Name="credit_history">
                <option selected>Choose...</option>
                <option value="1">Yes</option>
                <option value="0">No</option>
              </select>
            </div>
            <div className="input-group mb-3">
              Education:
              <select className="custom-select internalpadding" id="inputGroupSelect03" Name="education">
                <option selected>Choose...</option>
                <option value="0">Not graduate</option>
                <option value="1">Graduate</option>
              </select>
            </div>
            <div className="input-group mb-3">
              Property Area
              <select className="custom-select internalpadding" id="inputGroupSelect03" Name="prop_area">
                <option selected>Choose...</option>
                <option value="2">Urban</option>
                <option value="0">Rural</option>
              </select>
            </div>

            Applicant Income(in $ per month): <input type="number"></input><br/><br/>

            LoanAmount(in $): <input type="number"></input><br/><br/>

            Loan Amount Term(number of months): <input type="number"></input><br/><br/>
            <button type="submit" className="btn btn-primary" value="GetLoanPrediction">Get Loan Prediction</button>
          </form>
        </div>
      );
    }
  }

  export default LoanForm;