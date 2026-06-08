package com.sarah.spendwise.features.home;

import com.sarah.spendwise.features.expense.ExpenseView;
import com.sarah.spendwise.features.income.IncomeView;
import com.sarah.spendwise.util.ConsoleInput;

import java.util.Scanner;

public class HomeView {

    private HomeModel homeModel;
    private Scanner scanner = ConsoleInput.getInstance().getScanner();
    public HomeView(){

        this.homeModel = new HomeModel(this);

    }

    public void init(String process) {

        if(process.equals("Income")) {
            new IncomeView().init();
        }
        else if(process.equals("Expense")) {
            new ExpenseView().init();
        }

    }



//        boolean isTrue = true;
//        do{
//            System.out.println("Do you want to continue : ");
//
//            System.out.println("1.YES");
//            System.out.println("2.NO");
//            try {
//                int n = scanner.nextInt();
//
//                switch (n){
//                    case 1:
//                        System.exit(0);
//                        break;
//                    case 2:
//                        break;
//                    default:
//                        System.out.println("Please Choose Valid Option!");
//                }
//            }
//            catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }
//        while(isTrue);

}
