import React from 'react';

class LoanForm extends React.Component {
    render() {
      return (
        <div>
          <h1>Login </h1>
          <form>
            Gender: <input></input><br/>
            Married: <input></input><br/>
            Dependents: <input></input><br/>
            Education: <input></input><br/>
            Self_Employed: <input></input><br/>
            ApplicantIncome: <input></input><br/>
            CoapplicantIncome: <input></input><br/>
            LoanAmount: <input></input><br/>
            Loan_Amount_Term: <input></input><br/>
            Credit_History: <input></input><br/>
            Property_Area: <input></input><br/>
            {/* Loan_ID	Gender	Married	Dependents	Education	Self_Employed	ApplicantIncome	CoapplicantIncome	LoanAmount	Loan_Amount_Term	Credit_History	Property_Area	Loan_Status */}
            <button type="submit" value="GetLoanPrediction">Get Loan Prediction</button>
          </form>
        </div>
      );
    }
  }

  export default LoanForm;