package com.sarah.spendwise.data.dto;

public class Budget {
    private Category category;

    private double limitAmount;

    public void setBudget(Category category,
                          double limitAmount) {

        this.category = category;
        this.limitAmount = limitAmount;

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getLimitAmount() {
        return limitAmount;
    }
}
