    package com.sarah.spendwise;

    import com.sarah.spendwise.exception.ExceptionHandling;
    import com.sarah.spendwise.features.budget.add.AddBudgetView;
    import com.sarah.spendwise.features.budget.view.GetBudgetView;
    import com.sarah.spendwise.features.expense.ExpenseView;
    import com.sarah.spendwise.features.income.IncomeView;
    import com.sarah.spendwise.features.viewcategory.CategoryView;
    import com.sarah.spendwise.util.ConsoleInput;

    import java.util.InputMismatchException;
    import java.util.Scanner;

    public class SpendWise {
        public static void main(String[] args) throws ExceptionHandling {
            System.out.println("Welcome To Spend Wise!");

            boolean isTrue = true;
            do{

                System.out.println("\n1.Add Income");
                System.out.println("2.Add Expense");
                System.out.println("3.View Category wise Expense");
                System.out.println("4.Add Budget");
                System.out.println("5.Get BudgetList");
                System.out.println("6.Exit");
                System.out.print("Choose Your Option : ");
                Scanner scanner= ConsoleInput.getInstance().getScanner();
                try {
                    int n = scanner.nextInt();

                    switch (n){

                        case 1:
                            new IncomeView().init();
                            break;
                        case 2:
                            new ExpenseView().init();

                            break;
                        case 3:
                            new CategoryView().init();

                            break;
                        case 4:
                            new AddBudgetView().init();

                            break;
                        case 5:
                            new GetBudgetView().init();

                            break;
                        case 6:
                            System.out.println("Thank you for using SpendWise!");
                            scanner.close();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Please choose Correct Option!");
                            break;
                    }
                }
                catch (InputMismatchException e){
                    scanner.nextLine(); // clear invalid input!
                    try {
                        throw new ExceptionHandling("Invalid Option!", e);
                    }
                    catch (ExceptionHandling e1){
                        System.out.println(e1.getMessage());
                    }
                }
            }
            while(isTrue);
        }
    }
