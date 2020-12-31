package com.codingdojo.productscategories.repositories;

import java.util.List;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();

    // List<Category> findByProductIdIsNull();
    List<Category> findByProductsNotContains(Product product);
}
