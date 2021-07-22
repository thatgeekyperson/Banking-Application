import React, { useState, useEffect } from 'react';

function ClientStatus() {
  const [message, setMessage] = useState(0);
  const [client_id, setClientId] = useState(0);
  const [loan_id, setLoanId] = useState(0);
  const [client_name, setClientName] = useState(0);
  const [loan_amount, setLoanAmount] = useState(0);
  const [loan_amount_remaining, setLoanAmountRemaining] = useState(0);
  const [loan_term, setLoanTerm] = useState(0);
  const [transactions, setTransactions] = useState([]);

  var client_state = null

  useEffect(() => {
    fetch('http://localhost:5000/clientstatus').then(res => res.json()).then(data => {
      console.log(data.client_data)
      setMessage(data.message);
      var client = data.client_data.client
      var loan_details = data.client_data.loan_details
      var transactions_pl = data.client_data.transactions 
      var transactions_li = ""
      var key, val
      for([key, val] of Object.entries(transactions_pl)) {
        transactions_li += `<li>${val.transaction_id}: ${val.amount_paid}</li>`
      }
      setTransactions(transactions_li)

      setClientId(client.bank_id)
      setClientName(client.name)
      setLoanId(client.loan_id)
      setLoanTerm(loan_details.loan_term_months)
      setLoanAmount(loan_details.loan_amount)
      setLoanAmountRemaining(loan_details.loan_amount_remaining)



    });
  }, []);

  return (
    <div className="pad">
      <h1>Client Status</h1>
      <div>Client ID: {client_id} <br/>Client Name: {client_name} <br/>Loan ID: {loan_id}<br/></div>
      <div>Loan Amount: {loan_amount} <br/>Loan Term: {loan_term} <br/>Loan Amount Remaining: {loan_amount_remaining}<br/></div>
      <br/>
      <ul dangerouslySetInnerHTML={{__html: transactions}}></ul>
    </div>
  );
}

  export default ClientStatus;