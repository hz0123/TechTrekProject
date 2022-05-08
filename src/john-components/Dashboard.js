import React, { useState, useEffect, useSyncExternalStore } from 'react'
import Header from './Header.js'
import ExpenseForm from './ExpenseForm.js';
import ExpenseList from './ExpenseList.js';
import DataList from './DataList.js'

function Dashboard() {
    const [expense, setExpense] = useState([]);
    const [data, setData] = useState([]);
    const [totalExpense, setTotalExpense] = useState(0);

  //   const data = [{
  //     "id": 1,
  //     "projectId": 2,
  //     "categoryId": 2,
  //     "name": "Server Maintenance",
  //     "description": "Server maintenance and upgrading work to incorporate BC plans",
  //     "amount": 30000,
  //     "createdAt": "2021-11-04T16:00:00.000Z",
  //     "createdBy": "Jacky",
  //     "updatedAt": "2021-11-06T16:00:00.000Z",
  //     "updatedBy": "Jacky"
  // },
  // {
  //     "id": 2,
  //     "projectId": 3,
  //     "categoryId": 4,
  //     "name": "Consultant",
  //     "description": "Consultancy services for integration work",
  //     "amount": 10000,
  //     "createdAt": "2021-11-06T16:00:00.000Z",
  //     "createdBy": "Helen",
  //     "updatedAt": "2021-11-07T16:00:00.000Z",
  //     "updatedBy": "Helen"
  // }];

  useEffect(() => {
    fetch("/expense",{
      'methods':'GET,POST',
      headers : {
        'Content-Type':'application/json'
      }
    }).then(
      res => res.json()
    ).then(
      res => {
        setData(res)
        console.log(res)
      }
    )
  })
  
  useEffect(() => {
    let temp = 0;
    for(let i =0; i < expense.length; i++) {
      temp += parseInt(expense[i].price);
    }

    setTotalExpense(temp)
  }, [expense])

  return (
    <div className = "App">
      
          {/* <DataList 
          data={data} 
          /> */}

        <ul>
          {data.map((data) => (
            <li key={data.projectId}>
              <p>name: {data.name}</p>
              <p>amount: ${data.amount}</p>
              <p>date: {data.updatedAt}</p>
              <br></br>
            </li>))}
        </ul>
        <Header totalExpense={totalExpense} />
        <ExpenseForm expense={expense} setExpense={setExpense}/>
        <ExpenseList expense={expense} setExpense={setExpense}/>
    </div>
  )
}
export default Dashboard