import React, { useState, useEffect } from 'react'
import Header from './Header.js'
import ExpenseForm from './ExpenseForm.js';
import ExpenseList from './ExpenseList.js';

function Dashboard() {
    const [expense, setExpense] = useState([]);
    const [totalExpense, setTotalExpense] = useState(0);

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
        <ExpenseList expense={expense} setExpense={setExpense} />
        </div>
  )
}

export default Dashboard