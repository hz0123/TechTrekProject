import React, { useState } from "react";
import Dashboard from "./john-components/Dashboard";
import LoginForm from './mudz-components/LoginForm'
import './Dashboard.css'

function App() {

  const adminUser = {
    username: "admin@admin.com",
    password: "admin123"
  }

  const [user, setUser] = useState({username:""});
  const [error, setError] = useState("");

  const Login = details => {
    console.log(details);
    if (details.username == adminUser.username && details.password == adminUser.password){
      console.log("Logged In")
      setUser({
        username: details.username
      });
    } else {
      console.log("Details Do Not Match!");
      setError("Details Do Not Match!")
    }
  }

  const Logout = () => {
    setUser({username: ""});
  }

  return (
    <div className="App">
      {(user.username != "") ? (
        <div className="welcome">
          <h2>Welcome, <span>{user.username}</span></h2>
          <button onClick={Logout}>Logout</button>
        </div>
      ) : (
        <LoginForm Login={Login} error={error} />
      )}
    </div>
  );
      }
export default App