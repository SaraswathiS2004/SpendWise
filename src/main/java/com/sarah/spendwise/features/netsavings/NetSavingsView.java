package com.sarah.spendwise.features.netsavings;

public class NetSavingsView {

    private NetSavingsModel netSavingsModel;

    public NetSavingsView(){
        this.netSavingsModel = new NetSavingsModel(this);
    }
    public void init(){
        double totalIncome = netSavingsModel.getTotalIncome();
        double totalExpense = netSavingsModel.getTotalExpense();
        double netSavings = netSavingsModel.calculateNetSavings();
        showSavings(totalIncome, totalExpense, netSavings);
    }

    void showSavings(double totalIncome, double totalExpense, double netSavings){
        System.out.println("Total Income  : " + totalIncome);
        System.out.println("Total Expense : " + totalExpense);
        System.out.println("Net Savings   : " + netSavings);
        if(netSavings < 0){
            System.out.println("[WARNING] You are spending more than you earn!");
        }
    }
}
