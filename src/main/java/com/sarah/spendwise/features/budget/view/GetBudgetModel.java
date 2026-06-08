package com.sarah.spendwise.features.budget.view;

import com.sarah.spendwise.data.dto.Budget;
import com.sarah.spendwise.data.repsitory.SpendWiseDB;

import java.util.List;

class GetBudgetModel {

    private GetBudgetView getBudgetView;
    private SpendWiseDB spendWiseDB = SpendWiseDB.getInstance();

    public GetBudgetModel(GetBudgetView getBudgetView){
        this.getBudgetView = getBudgetView;
    }

    List<Budget> getBudget(){
        List<Budget> budgetList = spendWiseDB.getBudget();
        return budgetList;
    }
}
