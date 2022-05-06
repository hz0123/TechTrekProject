import React, { useState } from "react";
import axios from "axios";
import Dashboard from "./john-components/Dashboard";
import LoginForm from './mudz-components/LoginForm'

function App() {

  const adminUser = {
    email: "admin@admin.com",
    password: "admin123"
  }

  const [user, setUser] = useState({name:"", email:""});
  const [error, setError] = useState("");

  const Login = details => {
    console.log(details);
    if (details.email == adminUser.email && details.password == adminUser.password){
      console.log("Logged In")
      setUser({
        name: details.name,
        email: details.email
      });
    } else {
      console.log("Details Do Not Match!");
      setError("Details Do Not Match!")
    }
  }

  const Logout = () => {
    setUser({name: "", email: ""});
  }

  function getData() {
    axios({
      method: "GET",
      url:"/login",
    })
    .then((response) => {
      const res =response.data
      setUser(({
        email: res.email,
        password: res.password}))
    }).catch((error) => {
      if (error.response) {
        console.log(error.response)
        console.log(error.response.status)
        console.log(error.response.headers)
        }
    })}

  return (
    <div className="App">
      {/*{(user.email != "") ? (
        <div className="welcome">
          <h2>Welcom, <span>{user.name}</span></h2>
          <button>onClick={Logout}</button>
        </div>
      ) : (
        <LoginForm />
      )}
      */}

        
      

      <Dashboard />
    </div>
  );
}

export default App;