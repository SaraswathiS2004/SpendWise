package com.sarah.spendwise.features.expense;

import com.sarah.spendwise.data.dto.Category;
import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.dto.PaymentType;
import com.sarah.spendwise.data.repsitory.SpendWiseDB;

class ExpenseModel {

    private ExpenseView expenseView;

    private SpendWiseDB spendWiseDB =
            SpendWiseDB.getInstance();

    public ExpenseModel(ExpenseView expenseView) {

        this.expenseView = expenseView;
    }

    public void createExpense(Category category,
                              double amount,
                              PaymentType paymentType, String date , String time ,
                              String note) {
        Expense expense = new Expense();
        expense.setExpense(category, amount, paymentType, date, time, note);
        spendWiseDB.addExpense(expense);
    }

    private boolean isValidAmount(double amount){

        return amount > 0;
    }
}