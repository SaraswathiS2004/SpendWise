package com.sarah.spendwise.data.repsitory;

import com.sarah.spendwise.data.dto.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SpendWiseDB {

    private static SpendWiseDB spendWiseDB;

    public static  SpendWiseDB getInstance(){
        if(spendWiseDB == null){
            spendWiseDB = new SpendWiseDB();
        }
        return spendWiseDB;
    }

    private static final String FILE_PATH_INCOME = "incomeDetails.txt";
    private static final String FILE_PATH_EXPENSE = "expenseDetails.txt";
    private static final String FILE_PATH_BUDGET = "budget.txt";
    private static final String SEPARATOR = "|";

    public void addIncome(Income income){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_INCOME , true));
            String line = income.getName() + SEPARATOR + income.getMonthlySalary() + SEPARATOR + income.getDate()
                    + SEPARATOR + income.getTime() + SEPARATOR + income.getNote();

            writer.write(line);
            writer.newLine();
            writer.close();
            System.out.println("Data saved to : " + FILE_PATH_INCOME);
        }
        catch (IOException e){
            System.out.println("Failed to save: " + e.getMessage());
        }
    }

    public List<Income> getIncome(){

        List<Income> list = new ArrayList<>();
        try{

            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_INCOME));

                String line;

                while((line = reader.readLine()) != null){
                    String [] split = line.split("\\|");
                    Income income = new Income();
                    String name = split[0];
                    float monthlySalary = Float.parseFloat(split[1]);
                    LocalDate date = LocalDate.parse(split[2]);
                    LocalTime time = LocalTime.parse(split[3]);
                    String note = split[4];
                    income.setIncome(name , monthlySalary ,note ,date ,time);
                    list.add(income);
                }
            }
            catch (IOException e){
                System.out.println("Failed to get Expense : "+ e.getMessage());
            }
        return list;
    }



    public void addExpense(Expense expense){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_EXPENSE , true));
            String line = expense.getCategory() + SEPARATOR + expense.getAmount() + SEPARATOR + expense.getDate()
                    + SEPARATOR + expense.getTime() + SEPARATOR + expense.getPaymentMethod() + SEPARATOR + expense.getNote();

            writer.write(line);
            writer.newLine();
            writer.close();
            System.out.println("Data saved to : " + FILE_PATH_EXPENSE);
        }
        catch (IOException e){
            System.out.println("Failed to save: " + e.getMessage());
        }
    }

    public List<Expense> getExpense(){

        List<Expense> list = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_EXPENSE));

            String line;

            while((line = reader.readLine()) != null){
                String [] split = line.split("\\|");
                Category category = Category.valueOf(split[0]);
                double amount = Float.parseFloat(split[1]);
                String date = split[2];
                String time = split[3];
                PaymentType paymentType = PaymentType.valueOf(split[4]);
                String note = split[5];
                Expense expense = new Expense();
                expense.setExpense(category , amount ,paymentType , date ,time , note);
                list.add(expense);
            }
        }
        catch (IOException e){
            System.out.println("Failed to get Expense : "+ e.getMessage());
        }

        return list;
    }

    public void addBudget(Budget budget){
        try{

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_BUDGET , true));
            String line = budget.getCategory() + SEPARATOR + budget.getLimitAmount();

            writer.write(line);
            writer.newLine();
            writer.close();
            System.out.println("Data saved to : " + FILE_PATH_BUDGET);
        }
        catch (IOException e){
            System.out.println("Failed to save: " + e.getMessage());
        }
    }

    public List<Budget> getBudget(){
        List<Budget> list = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH_BUDGET));

            String line;

            while((line = reader.readLine()) != null){
                String [] split = line.split("\\|");
                Category category = Category.valueOf(split[0]);
                double limitAmount = Float.parseFloat(split[1]);

                Budget budget = new Budget();
                budget.setBudget(category , limitAmount);
                list.add(budget);
            }
        }
        catch (IOException e){
            System.out.println("Failed to get Expense : "+ e.getMessage());
        }

        return list;
    }
}
