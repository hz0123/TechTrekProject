import React, { useState, useEffect, useSyncExternalStore } from 'react'
import Header from './Header.js'
import ExpenseForm from './ExpenseForm.js';
import ExpenseList from './ExpenseList.js';

function Dashboard() {
    const [expense, setExpense] = useState([]);
    const [totalExpense, setTotalExpense] = useState(0);

  // useEffect(() => {
  //   fetch("/expense").then(
  //     res => res.json()
  //   ).then(
  //     expense => {
  //       setExpense(expense)
  //       console.log(expense)
  //     }
  //   )
  // }
  // )
  
  useEffect(() => {
    let temp = 0;
    for(let i =0; i < expense.length; i++) {
      temp += parseInt(expense[i].price);
    }

    setTotalExpense(temp)
  }, [expense])

  return (
    <div className = "App">
        <Header totalExpense={totalExpense} />
        <ExpenseForm expense={expense} setExpense={setExpense}/>
        <ExpenseList expense={expense} setExpense={setExpense}/>
        <ul>
          {useSyncExternalStore.map((expense) => 
          <li key={data.project_id}>
            <p>{data.name}</p>

          </li>)}
        </ul>
    </div>
  )
}

export default Dashboard