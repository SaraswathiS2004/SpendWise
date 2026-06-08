package com.sarah.spendwise.data.repsitory;

import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.dto.Income;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

    private static final String FILE_PATH_INCOME = "incomeDetails.txt";
    private static final String FILE_PATH_EXPENSE = "incomeDetails.txt";
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

//    public void addExpense(Expense expense){
//        try{
//            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH_INCOME , true));
//            String line = income.getName() + SEPARATOR + income.getMonthlySalary() + SEPARATOR + income.getDate()
//                    + SEPARATOR + income.getTime() + SEPARATOR + income.getNote();
//
//            writer.write(line);
//            writer.newLine();
//            writer.close();
//            System.out.println("Data saved to : " + FILE_PATH_INCOME);
//        }
//        catch (IOException e){
//            System.out.println("Failed to save: " + e.getMessage());
//        }
//    }
}
