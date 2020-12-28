package com.codingdojo.mvc.controllers;

import java.util.List;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    // @RequestMapping("/")
    // public String index() {
    // return "redirect:/books/index.jsp";
    // }

    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
}
