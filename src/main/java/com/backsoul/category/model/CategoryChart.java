package com.backsoul.category.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryChart {
    private String name;
    private int amount;
    public List<CategoryChart> categoriesChart;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmountCategory(String category, int amount) {
        for (var month : this.categoriesChart) {
            if (month.getName().equals(category)) {
                month.setAmount(amount);
            }
        }
    }

    public void setupMonths(List<Category> categories) {
        List<CategoryChart> categoriesChart = new ArrayList<CategoryChart>();
        for (var category : categories) {
            CategoryChart categoryChart = new CategoryChart();
            categoryChart.setAmount(0);
            categoryChart.setName(category.getName());
            categoriesChart.add(categoryChart);
        }
        this.categoriesChart = categoriesChart;
    }
}
