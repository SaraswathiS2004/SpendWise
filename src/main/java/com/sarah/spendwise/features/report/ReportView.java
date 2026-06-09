package com.sarah.spendwise.features.report;

import com.sarah.spendwise.data.dto.Budget;
import com.sarah.spendwise.data.dto.Category;
import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.dto.PaymentType;
import com.sarah.spendwise.features.netsavings.NetSavingsView;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.List;

public class ReportView {

    private ReportModel reportModel;

    public ReportView(){
        this.reportModel = new ReportModel(this);
    }

    public void init(){

        printPattern();
        new NetSavingsView().init();
        reportModel.getExpense();
        reportModel.getBudgets();

    }

    void printPattern(){

        System.out.println("\n========== Finance Report ================");

    }

    void showFailedMessage(String message){
        System.out.println(message);
    }

    void showExpense(List<Expense> expenses){

        System.out.println("=========== Expenses ================");

        int index = 1;
        for(Expense expense : expenses){

            System.out.println(index++ +" . "+ expense.getCategory());
            System.out.println("Amount : "+expense.getAmount());
            System.out.println("Payment Method : "+ expense.getPaymentMethod());
            System.out.println("Date : "+ expense.getDate());
            System.out.println("Time : "+ expense.getTime());
            System.out.println("Note : "+ expense.getNote());
            System.out.println();
        }

        System.out.println("==================================================");
    }

    void showBudgets(List<Budget> budgets){
        System.out.println("============= Budgets ================");

        int index = 1;

        for(Budget budget : budgets){

            System.out.println(index ++ +" . "+ budget.getCategory());
            System.out.println("Limit Amount : " + budget.getLimitAmount());
            System.out.println();

        }
        System.out.println("======================================================");
    }
}
