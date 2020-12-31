package com.codingdojo.productscategories.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.repositories.ProductRepository;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // returns all the people
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    // create a person
    public Product createProduct(Product p) {
        return productRepository.save(p);
    }

    // retrieve a person
    public Product findProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

    // return list of products that current category does not have
    public List<Product> findProductsNotInCategory(Category category) {
        return productRepository.findByCategoriesNotContains(category);
    }

    // update a person
    public void updateProduct(Product p) {
        productRepository.save(p);
    }
}
