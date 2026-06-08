package com.sarah.spendwise.features.income;

import com.sarah.spendwise.data.dto.Income;
import com.sarah.spendwise.data.repsitory.SpendWiseDB;

import java.time.LocalDate;
import java.time.LocalTime;

class IncomeModel {

    private IncomeView incomeView;
    private SpendWiseDB spendWiseDB = SpendWiseDB.getInstance();
    public IncomeModel(IncomeView incomeView) {
        this.incomeView = incomeView;
    }

    public Income addIncome(String name, float monthlySalary, String note) {
        if (!isValidName(name)) {
            incomeView.showError("Name cannot be empty.");
            return null;
        }
        if (!isValidSalary(monthlySalary)) {
            incomeView.showError("Monthly salary must be greater than zero.");
            return null;
        }

        Income income = new Income();
        income.setIncome(name , monthlySalary , note , LocalDate.now() , LocalTime.now());
        spendWiseDB.addIncome(income);
        return income;
    }

    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private boolean isValidSalary(float salary) {
        return salary > 0;
    }
}