package com.backsoul.category.model;

import java.util.ArrayList;
import java.util.List;

public class CategoryChart {
    private String name;
    private int amount;
    private String color;

    public List<CategoryChart> categoriesChart;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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

    public void setColorCategory(String category, String color) {
        for (var month : this.categoriesChart) {
            if (month.getName().equals(category)) {
                month.setColor(color);
            }
        }
    }

    public CategoryChart getCategory(String monthName) {
        for (var month : this.categoriesChart) {
            if (month.getName().equals(monthName)) {
                return month;
            }
        }
        return null;
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
