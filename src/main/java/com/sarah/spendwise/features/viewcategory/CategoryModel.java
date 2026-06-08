package com.sarah.spendwise.features.viewcategory;

import com.sarah.spendwise.SpendWise;
import com.sarah.spendwise.data.dto.Category;
import com.sarah.spendwise.data.dto.Expense;
import com.sarah.spendwise.data.repsitory.SpendWiseDB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CategoryModel {

    private CategoryView categoryView;

    private static SpendWiseDB spendWiseDB = SpendWiseDB.getInstance();

    public CategoryModel(CategoryView categoryView){
        this.categoryView = categoryView;
    }

    static List<List<Expense>> getCategory(){

        String [] categories = {"FOOD" , "TRANSPORT" , "SHOPPING"  , "BILLS" , "HEALTH" , "OTHER"};

        List<List<Expense>> expenseList = new ArrayList<>();

        for(int i = 0; i< categories.length; i++){

            Category category = Category.valueOf(categories[i]);

            List<Expense> temp = getExpense(category);
            if(temp != null) {

                expenseList.add(temp);

            }

        }

        return expenseList;
    }

    static List<Expense> getExpense(Category category){

        List<Expense> result = new ArrayList<>();

        List<Expense> categories = spendWiseDB.getExpense();

        for(Expense expense : categories){
            if(category.equals(expense.getCategory())){
                result.add(expense);
            }
        }

        return result;
    }
}
