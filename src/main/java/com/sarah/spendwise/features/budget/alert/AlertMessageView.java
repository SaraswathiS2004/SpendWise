package com.sarah.spendwise.features.budget.alert;

public class AlertMessageView {

    private AlertMessageModel alertMessageModel;

    public AlertMessageView(){
        this.alertMessageModel = new AlertMessageModel(this);
    }

    public void init(){
        alertMessageModel.alertBudget();
    }

    void showFailedMessage(String message){
        System.out.println(message);
    }

    void alertMessage(String message){
        System.out.println(message);
    }
}
