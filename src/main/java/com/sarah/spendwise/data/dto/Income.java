package com.sarah.spendwise.data.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Income {
    private String name;
    private float monthlySalary;
    private LocalDate date;
    private LocalTime time;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(float monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public Income(String name, float monthlySalary, String note) {
        this.name = name;
        this.monthlySalary = monthlySalary;
        this.note = note;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }
}
