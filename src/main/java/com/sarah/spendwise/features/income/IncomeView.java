package com.sarah.spendwise.features.income;

import com.sarah.spendwise.data.dto.Income;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class IncomeView {

    private IncomeModel incomeModel;
    private final Scanner scanner;
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd MMM yyyy");
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("hh:mm a");

    public IncomeView() {
        this.incomeModel = new IncomeModel(this);
        this.scanner = new Scanner(System.in);
    }

    public void init() {
        handleAddIncome();
    }

    private void handleAddIncome() {
        System.out.println("\n── Add Income ──");
        String name = readString("Your name          : ");
        float salary = readFloat("Monthly salary (₹) : ");
        String note = readString("Note (optional)    : ");

        Income saved = incomeModel.addIncome(name, salary, note);
        if (saved != null) {
            showSuccess("Income saved successfully!");
        }
    }

    public void showSuccess(String message) {
        System.out.println(message);
    }

    public void showError(String message) {
        System.out.println(message);
    }
    private String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                showError("Please enter a whole number.");
            }
        }
    }

    private float readFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                float value = Float.parseFloat(line);
                if (value <= 0) {
                    showError("Amount must be greater than zero.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                showError("Please enter a valid number (e.g. 50000).");
            }
        }
    }
}