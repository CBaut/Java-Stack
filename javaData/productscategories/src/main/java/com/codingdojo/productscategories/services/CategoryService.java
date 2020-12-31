package com.codingdojo.productscategories.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.CategoryRepository;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // returns all the people
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    // create a person
    public Category createCategory(Category c) {
        return categoryRepository.save(c);
    }

    // retrieve a person
    public Category findCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    // return list of categories that current product does not have
    public List<Category> findCategoriesNotInProduct(Product product) {
        return categoryRepository.findByProductsNotContains(product);
    }

    // update a person
    public void updateCategory(Category c) {
        categoryRepository.save(c);
    }
}
