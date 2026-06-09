package com.sarah.spendwise.features.report;

import com.sarah.spendwise.data.dto.Budget;
import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.dto.PaymentType;
import com.sarah.spendwise.data.repsitory.SpendWiseDB;

import java.util.List;

class ReportModel {

    private ReportView reportView;

    private SpendWiseDB spendWiseDB = SpendWiseDB.getInstance();

    public ReportModel(ReportView reportView){
        this.reportView = reportView;
    }

    void getExpense(){
        List<Expense> expenseList = spendWiseDB.getExpense();
        if(expenseList.isEmpty()){
            reportView.showFailedMessage("There is no Expense Found!");
        }
        else{
            reportView.showExpense(expenseList);
        }
    }

    void getBudgets(){
        List<Budget> budgets = spendWiseDB.getBudget();

        if(budgets.isEmpty()) {
            reportView.showFailedMessage("There is no Budgets!");
        }
        else {
            reportView.showBudgets(budgets);
        }
    }

}
