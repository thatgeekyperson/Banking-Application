import React, { useState, useEffect } from 'react';

function ClientStatus() {
  const [message, setMessage] = useState(0);
  const [client_data, setClientData] = useState(0);

  useEffect(() => {
    fetch('http://localhost:5000/clientstatus').then(res => res.json()).then(data => {
      console.log(data)
      setMessage(data.message);
      setClientData(data.client_data.client.bank_id)
    });
  }, []);

  return (
    <div className="pad">
      <h1>Client Status</h1>
      <div>{message}</div>
      <div>{client_data}</div>
    </div>
  );
}

  export default ClientStatus;