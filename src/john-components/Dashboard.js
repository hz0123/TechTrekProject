import React, { useState } from 'react'
import Header from './Header.js'
import ExpenseForm from './ExpenseForm.js';

function Dashboard() {
    const [expense, setExpense] = useState([]);
    const [totalExpense, setTotalExpense] = useState(0);



  return (
    <div className = "App">
        <Header totalExpense={totalExpense} />
        <ExpenseForm />
        </div>
  )
}

export default Dashboard