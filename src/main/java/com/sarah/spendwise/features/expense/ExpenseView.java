package com.sarah.spendwise.features.expense;

import com.sarah.spendwise.data.dto.Category;
import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.dto.PaymentType;
import com.sarah.spendwise.util.ConsoleInput;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ExpenseView {

    private ExpenseModel expenseModel;

    private Scanner scanner = ConsoleInput.getInstance().getScanner();

    public ExpenseView() {
        this.expenseModel = new ExpenseModel(this);
    }

    public void init() {

        System.out.println("Welcome To SpendWise!");

        while(true){
            prompt();
            System.out.println("Do you want to add another expense?");
            System.out.println("1.Yes");
            System.out.println("2.No");
            int option = scanner.nextInt();
            if(option == 2){
                break;
            }
        }

    }

    void prompt() {



        System.out.println("\n===== Add Expense =====");

        Category category = getCategory();

        System.out.print("Enter Amount : ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        PaymentType paymentMethod = getPaymentType();

        System.out.print("Enter Note : ");
        scanner.nextLine();
        String note = scanner.nextLine();

        String date = LocalDate.now().toString();
        String time = LocalTime.now().toString();

        expenseModel.createExpense(category, amount , paymentMethod ,  date , time , note);

    }

    Category getCategory() {

        while (true) {

            System.out.println("\n1.FOOD");
            System.out.println("2.TRANSPORT");
            System.out.println("3.SHOPPING");
            System.out.println("4.BILLS");
            System.out.println("5.HEALTH");
            System.out.println("6.OTHER");

            System.out.print("Choose Your Option : ");

            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    return Category.FOOD;

                case 2:
                    return Category.TRANSPORT;

                case 3:
                    return Category.SHOPPING;

                case 4:
                    return Category.BILLS;

                case 5:
                    return Category.HEALTH;

                case 6:
                    return Category.OTHER;

                default:
                    System.out.println("Invalid Category!");
            }
        }
    }

    PaymentType getPaymentType() {

        while (true) {

            System.out.println("\n1.CASH");
            System.out.println("2.UPI");
            System.out.println("3.CARD");
            System.out.print("Choose Your Option : ");
            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    return PaymentType.CASH;

                case 2:
                    return PaymentType.UPI;

                case 3:
                    return PaymentType.CARD;

                default:
                    System.out.println("Invalid Payment Type!");
            }
        }
    }
}
