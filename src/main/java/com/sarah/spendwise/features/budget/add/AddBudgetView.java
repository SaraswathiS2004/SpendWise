package com.sarah.spendwise.features.budget.add;

import com.sarah.spendwise.data.dto.Category;
import com.sarah.spendwise.util.ConsoleInput;

import java.util.Scanner;

public class AddBudgetView {

    private AddBudgetModel addBudgetModel;
    private Scanner scanner = ConsoleInput.getInstance().getScanner();

    public AddBudgetView(){
        this.addBudgetModel = new AddBudgetModel(this);
    }

    public void init(){
        prompt();
    }

    void prompt(){

        Category category = getCategory();
        double limitAmount = getAmount();

        addBudgetModel.setBudget(category , limitAmount);
    }

    Category getCategory(){
        while(true) {

            System.out.println("\n1.FOOD");
            System.out.println("2.TRANSPORT");
            System.out.println("3.SHOPPING");
            System.out.println("4.BILLS");
            System.out.println("5.HEALTH");
            System.out.println("6.OTHER");
            System.out.print("Enter you Category : ");
            String category = scanner.next();
            String error = addBudgetModel.validCategory(category);

            Category category1 = null;
            if(error == null){
                switch (category.trim()){
                    case "1" :
                        category1 = Category.FOOD;
                        break;
                    case "2":
                        category1 = Category.TRANSPORT;
                        break;
                    case "3":
                        category1 = Category.SHOPPING;
                        break;
                    case "4":
                        category1 = Category.BILLS;
                        break;
                    case "5":
                        category1 = Category.HEALTH;
                        break;
                    default:
                        category1 = Category.OTHER;
                        break;
                }
                return category1;
            }
        }
    }

    double getAmount(){
        while(true){
            System.out.println("Enter your budget limit amount : ");
            String input = scanner.next();
            String error = addBudgetModel.validAmount(input);
            if(error == null){
                return Double.parseDouble(input);
            } else {
                System.out.println(error);
            }
        }
    }

}
