import React from 'react';
import "./loanform.css"

class LoanForm extends React.Component {
    render() {
      return (
        <div className="pad">
          <h1>Loan Applicant Details </h1>
          <br/>
          <form action = "loan_form" method = "POST">
            Name: <input></input><br/>
            Date Of Birth: <input type="date"></input><br/><br/>
            <div className="input-group mb-3">
              Gender:  
              <select className="internalpadding" id="inputGroupSelect01">
                <option selected>Choose...</option>
                <option value="1">Male</option>
                <option value="2">Female</option>
                <option value="3">Other</option>
              </select>
            </div>
            <div className="input-group mb-3">
              Married:  
              <select className="custom-select internalpadding" id="inputGroupSelect01">
                <option selected>Choose...</option>
                <option value="1">Single</option>
                <option value="2">Married</option>
                <option value="3">Divorced</option>
              </select>
            </div>
            <div className="input-group mb-3">
              Self Employed:  
              <select className="custom-select internalpadding" id="inputGroupSelect02">
                <option selected>Choose...</option>
                <option value="1">yes</option>
                <option value="2">no</option>
              </select>
            </div>
            <div className="input-group mb-3">
              Credit History:  
              <select className="custom-select internalpadding" id="inputGroupSelect03">
                <option selected>Choose...</option>
                <option value="1">yes</option>
                <option value="2">no</option>
              </select>
            </div>
            Dependents: <input type="number"></input><br/>
            Applicant Income(in $ per month): <input type="number"></input><br/>
            Coapplicant Income(in $ per month): <input type="number"></input><br/>
            LoanAmount(in $): <input type="number"></input><br/>
            Loan Amount Term(number of days): <input type="number"></input><br/>
            Property Area (in sq miles): <input type="number"></input><br/>
            Education: <input></input><br/>
            <button type="submit" className="btn btn-primary" value="GetLoanPrediction">Get Loan Prediction</button>
          </form>
        </div>
      );
    }
  }

  export default LoanForm;