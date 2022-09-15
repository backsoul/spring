package com.backsoul.category.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backsoul.MainApplication;
import com.backsoul.category.model.Category;
import com.backsoul.category.model.CategoryChart;
import com.backsoul.category.services.CategoryServiceImpl;
import com.backsoul.utils.BodyData;

@RestController
@RequestMapping(MainApplication.BASE_API_URL + "/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @PostMapping()
    public Category createCategory(@RequestBody String body) {
        BodyData bodyData = new BodyData(body);
        String name = bodyData.getPayloadValue("name");
        String color = bodyData.getPayloadValue("color");
        return categoryServiceImpl.createCategory(bodyData.getUserValue("Id"), name, color);
    }

    @GetMapping()
    public List<Category> categories(@RequestBody String body) {
        BodyData bodyData = new BodyData(body);
        String userId = bodyData.getUserValue("Id");
        return categoryServiceImpl.findByUserId(userId);
    }

    @GetMapping("/report")
    public List<CategoryChart> categoriesReport(@RequestBody String body) {
        BodyData bodyData = new BodyData(body);
        String userId = bodyData.getUserValue("Id");
        return categoryServiceImpl.categoriesReport(userId);
    }
}
