package com.sarah.spendwise.features.budget.alert;

import com.sarah.spendwise.SpendWise;
import com.sarah.spendwise.data.dto.Budget;
import com.sarah.spendwise.data.dto.Category;
import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.dto.PaymentType;
import com.sarah.spendwise.data.repsitory.SpendWiseDB;

import java.util.HashMap;
import java.util.List;

class AlertMessageModel {

    private AlertMessageView alertMessageView;

    private SpendWiseDB spendWiseDB = SpendWiseDB.getInstance();

    public AlertMessageModel(AlertMessageView alertMessageView){
        this.alertMessageView = alertMessageView;
    }

    void alertBudget(){
        List<Budget> budgetList = spendWiseDB.getBudget();
        List<Expense> expenseList = spendWiseDB.getExpense();
        HashMap<Category , Double> map = new HashMap<>();

        if(budgetList.isEmpty()){
            alertMessageView.showFailedMessage("There is no Budgets");
        }
        else if(expenseList.isEmpty()){
            alertMessageView.showFailedMessage("There is no Expenses");
        }
        else{

            for(Expense expense : expenseList) {

                Category category1 = expense.getCategory();
                if (map.containsKey(category1)) {
                    map.put(category1, map.get(category1) + expense.getAmount());
                } else {
                    map.put(category1, expense.getAmount());
                }

            }

            for(Budget budget : budgetList){

                Category category = budget.getCategory();

                double limitAmount = budget.getLimitAmount();

                if(map.containsKey(category)){

                   int usedPercentage = (int) ((map.get(category)/limitAmount) * 100);

                   if(usedPercentage == 85){
                       alertMessageView.alertMessage("[WARNING] "+ usedPercentage + "% used for "+ category );
                   }
                   else if(usedPercentage >= 100) {
                       alertMessageView.alertMessage("[ALERT] Exceeded Budget for "+category+ " ! ");
                   }
                   else {
                       alertMessageView.alertMessage("[OK] "+usedPercentage+"% used for "+category+". You are within Budget!");
                   }
                }
            }


        }
    }
}
