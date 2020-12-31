package com.codingdojo.productscategories.repositories;

import java.util.List;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

    // List<Product> findByCategoryIdIsNull();

    List<Product> findByCategoriesNotContains(Category category);
}
