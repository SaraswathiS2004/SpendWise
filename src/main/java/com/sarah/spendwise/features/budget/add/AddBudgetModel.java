package com.sarah.spendwise.features.budget.add;

import com.sarah.spendwise.data.dto.Budget;
import com.sarah.spendwise.data.dto.Category;
import com.sarah.spendwise.data.repsitory.SpendWiseDB;

class AddBudgetModel {

    private AddBudgetView addBudgetView;
    private SpendWiseDB spendWiseDB = SpendWiseDB.getInstance();

    public AddBudgetModel(AddBudgetView addBudgetView){
        this.addBudgetView = addBudgetView;
    }

    String validCategory(String category){

        try {

            int n = Integer.parseInt(category);

            if(n < 0 || n > 6){
                return "Invalid Option";
            }
        }
        catch (Exception e){
            return "Enter Valid Option";
        }

        return null;
    }

    String validAmount(String input){
        if(input == null || input.trim().isEmpty()){
            return "Amount cannot be empty.";
        }
        try {
            double amount = Double.parseDouble(input.trim());
            if(amount <= 0){
                return "Amount must be greater than zero.";
            }
            return null;
        } catch (NumberFormatException e){
            return "Invalid amount. Please enter a valid number.";
        }
    }
    void setBudget(Category category , double limitAmount){
        Budget budget = new Budget();
        budget.setBudget(category , limitAmount);
        spendWiseDB.addBudget(budget);
    }
}
