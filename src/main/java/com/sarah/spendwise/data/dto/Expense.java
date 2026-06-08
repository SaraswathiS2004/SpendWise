package com.sarah.spendwise.data.dto;

public class Expense {
    private Category category;
    private double amount;
    private PaymentType paymentMethod;
    private String date;
    private String time;
    private String note;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setExpense(Category category, double amount , PaymentType paymentMethod , String date , String time , String note){
        this.category = category;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.time = time;
        this.note = note;
    }
}
