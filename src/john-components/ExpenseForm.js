import React from 'react'

function ExpenseForm() {
  return (
    <form className="expense-form">
        <div className='form-inner'>
            <input type="text" name="desc" id="desc" 
            placeholder='Expense Description...'/>
            <input type="number" name="price" id ="price"
            placeholder='Price...'/>
            <input type="date" name="date" id="date"
            placeholder="Expense date..."/>
            <input type = "submit" value = "Add Expense" />
        </div>
    </form>
  )
}

export default ExpenseForm;