package com.sarah.spendwise.features.viewcategory;

import com.sarah.spendwise.data.dto.Category;
import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.dto.PaymentType;

import java.util.List;

public class CategoryView {

    private CategoryModel categoryModel;

    public CategoryView(){
        this.categoryModel = new CategoryModel(this);
    }

    public void init(){
        List<List<Expense>> list = categoryModel.getCategory();

        showCategory(list);
    }

    void showCategory(List<List<Expense>> list){

        if(list == null) return;

        System.out.println("============ Category Vice ==========");

        for(List<Expense> expense : list){
            for(Expense e : expense) {
                System.out.println("Category : " + e.getCategory());
                System.out.println("Amount : "+ e.getAmount());
                System.out.println("Payment Type : "+ e.getPaymentMethod());
                System.out.println("Date : "+ e.getDate());
                System.out.println("Time : "+ e.getTime());
                System.out.println("Note : "+ e.getNote());
                System.out.println("====================================================");
            }
        }

    }

}
