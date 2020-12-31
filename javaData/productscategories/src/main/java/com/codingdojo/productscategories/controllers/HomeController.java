package com.codingdojo.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import com.codingdojo.productscategories.models.Category;
import com.codingdojo.productscategories.models.Product;
import com.codingdojo.productscategories.services.CategoryService;
import com.codingdojo.productscategories.services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public HomeController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Category> categories = categoryService.findAllCategories();
        List<Product> products = productService.findAllProducts();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "index.jsp";
    }

    @RequestMapping("/products/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "/products/new.jsp";
    }

    @PostMapping("/products")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/new.jsp";
        } else {
            productService.createProduct(product);
            System.out.println("Product created successfully");
            return "redirect:/";
        }
    }

    @RequestMapping("/products/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProductById(id);
        List<Category> categories = categoryService.findCategoriesNotInProduct(product);
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "/products/show.jsp";
    }

    @PostMapping("/products/{id}/category/add")
    public String addCategoryToProduct(@PathVariable("id") Long productId, @RequestParam("category") Long categoryId) {
        Product product = productService.findProductById(productId);
        product.addCategory(categoryService.findCategoryById(categoryId));
        productService.updateProduct(product);
        return "redirect:/products/" + product.getId();
    }

    @RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "/categories/new.jsp";
    }

    @PostMapping("/categories")
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/categories/new.jsp";
        } else {
            categoryService.createCategory(category);
            System.out.println("Category created successfully");
            return "redirect:/";
        }
    }

    @RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.findCategoryById(id);
        List<Product> products = productService.findProductsNotInCategory(category);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "/categories/show.jsp";
    }

    @PostMapping("/categories/{id}/product/add")
    public String addProductToCategory(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId) {
        Category category = categoryService.findCategoryById(categoryId);
        category.addProduct(productService.findProductById(productId));
        categoryService.updateCategory(category);
        return "redirect:/categories/" + category.getId();
    }
}
