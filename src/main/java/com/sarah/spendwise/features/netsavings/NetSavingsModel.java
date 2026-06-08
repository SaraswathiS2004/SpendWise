package com.sarah.spendwise.features.netsavings;

import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.dto.Income;
import com.sarah.spendwise.data.repsitory.SpendWiseDB;

import java.util.List;

class NetSavingsModel {

    private NetSavingsView netSavingsView;
    private SpendWiseDB spendWiseDB = SpendWiseDB.getInstance();

    public NetSavingsModel(NetSavingsView netSavingsView){
        this.netSavingsView = netSavingsView;
    }

    double calculateNetSavings(){
        double totalIncome = getTotalIncome();
        double totalExpense = getTotalExpense();
        return totalIncome - totalExpense;
    }

    double getTotalIncome(){
        List<Income> incomeList = spendWiseDB.getIncome();
        double total = 0;
        for(Income income : incomeList){
            total += income.getMonthlySalary();
        }
        return total;
    }

    double getTotalExpense(){
        List<Expense> expenseList = spendWiseDB.getExpense();
        double total = 0;
        for(Expense expense : expenseList){
            total += expense.getAmount();
        }
        return total;
    }
}
