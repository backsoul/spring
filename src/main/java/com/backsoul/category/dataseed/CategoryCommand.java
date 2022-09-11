package com.backsoul.category.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.backsoul.category.model.Category;
import com.backsoul.category.repository.CategoryRepository;

@Component
public class CategoryCommand implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        // if (categoryRepository.count() == 0) {
        // Category category1 = new Category();
        // category1.setName("Creditos");
        // Category category2 = new Category();
        // category2.setName("Telecomunicaciones");
        // Category category3 = new Category();
        // category3.setName("Comida");
        // categoryRepository.save(category1);
        // categoryRepository.save(category2);
        // categoryRepository.save(category3);
        // }
        // System.out.println(categoryRepository.count());
    }
}