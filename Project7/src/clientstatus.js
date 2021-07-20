import React, { useState, useEffect } from 'react';import "./login.css";

function ClientStatus() {
//   const [message, setMessage] = useState(0);

//   useEffect(() => {
//     fetch('http://localhost:5000/clientstatus').then(res => res).then(data => {
//       setMessage(data.message);
//     });
//   }, []);

  return (
    <div className="pad">
        Client Status
    </div>
  );
}

  export default ClientStatus;