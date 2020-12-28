// SERVICE LAYER that handles Controller /API requests and bounces with the Repository level to query from and store to database

package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    // update a book
    public Book updateBook(Book b) {
        // something happens here
        return bookRepository.save(b);
    }

    // deletes a book
    public void deleteBook(Long id) {
        // not sure what to put here...
        bookRepository.deleteById(id);
    }
}
