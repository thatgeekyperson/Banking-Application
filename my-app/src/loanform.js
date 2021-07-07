import React from 'react';
import "./loanform.css"

class LoanForm extends React.Component {
    render() {
      return (
        <div class="pad">
          <h1>Loan Applicant Details </h1>
          <br/>
          <form>
            Name: <input></input><br/>
            Date Of Birth: <input type="date"></input><br/><br/>
            <div class="input-group mb-3">
              {/* <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Gender</label>
              </div> */}
              Gender:  
              <select class="internalpadding" id="inputGroupSelect01">
                <option selected>Choose...</option>
                <option value="1">Male</option>
                <option value="2">Female</option>
                <option value="3">Other</option>
              </select>
            </div>
            <div class="input-group mb-3">
              {/* <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Married</label>
              </div> */}
              Married:  
              <select class="custom-select" id="inputGroupSelect01" class="internalpadding">
                <option selected>Choose...</option>
                <option value="1">Single</option>
                <option value="2">Married</option>
                <option value="3">Divorced</option>
              </select>
            </div>
            <div class="input-group mb-3">
              {/* <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Self Employed?</label>
              </div> */}
              Self Employed:  
              <select class="custom-select" id="inputGroupSelect01" class="internalpadding">
                <option selected>Choose...</option>
                <option value="1">yes</option>
                <option value="2">no</option>
              </select>
            </div>
            <div class="input-group mb-3">
              {/* <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Credit History</label>
              </div> */}
              Credit History:  
              <select class="custom-select" id="inputGroupSelect01" class="internalpadding">
              {/* <span class="input-group-text" id="inputGroup-sizing-lg"> */}
                <option selected>Choose...</option>
                <option value="1">yes</option>
                <option value="2">no</option>
              {/* </span>  */}
              </select>
            </div>
            Dependents: <input type="number"></input><br/>
            Applicant Income(in $ per month): <input type="number"></input><br/>
            Coapplicant Income(in $ per month): <input type="number"></input><br/>
            LoanAmount(in $): <input type="number"></input><br/>
            Loan Amount Term(number of days): <input type="number"></input><br/>
            Property Area (in sq miles): <input type="number"></input><br/>
            Education: <input></input><br/>
            {/* Loan_ID	Gender	Married	Dependents	Education	Self_Employed	ApplicantIncome	CoapplicantIncome	LoanAmount	Loan_Amount_Term	Credit_History	Property_Area	Loan_Status */}
            <button type="submit" class="btn btn-primary" value="GetLoanPrediction">Get Loan Prediction</button>
          </form>
        </div>
      );
    }
  }

  export default LoanForm;