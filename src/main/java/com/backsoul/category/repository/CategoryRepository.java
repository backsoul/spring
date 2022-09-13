package com.backsoul.category.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backsoul.category.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, String> {
    @Query(value = "SELECT id, name,user_id FROM categories", nativeQuery = true)
    List<Category> findByuserId(String userId);

}
