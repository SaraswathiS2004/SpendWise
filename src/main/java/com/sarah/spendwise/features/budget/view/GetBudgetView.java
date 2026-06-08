package com.sarah.spendwise.features.budget.view;

import com.sarah.spendwise.data.dto.Budget;

import java.util.List;

public class GetBudgetView {

    private GetBudgetModel getBudgetModel;

    public GetBudgetView(){
        this.getBudgetModel = new GetBudgetModel(this);
    }

    public void init(){
       List<Budget> budgetList = getBudgetModel.getBudget();
       if(budgetList.size() > 0) {
           showBudgets(budgetList);
       }
       else {
           showFailedBudget();
       }

    }

    void showBudgets(List<Budget> budgetList){
        System.out.println("Your Budgets : ");
        int index = 1;
        for(Budget budget : budgetList){
            System.out.println(index++ + ". " + budget.getCategory() + " - " + budget.getLimitAmount());
        }
    }

    void showFailedBudget(){
        System.out.println("No budgets found. Please add one!");
    }

}
