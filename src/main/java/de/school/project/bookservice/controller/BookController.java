package de.school.project.bookservice.controller;

import de.school.project.bookservice.model.Book;
import de.school.project.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable String id) {
        Optional<Book> optBook = service.findById(id);

        if (optBook.isEmpty()) {
            throw new IllegalStateException("No Book with ID: " + id);
        }

        return optBook.get();
    }

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
        return service.createBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable String id, @RequestBody Book book) {
        return service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable String id) {
        return service.deleteBook(id);
    }

    @GetMapping("/author/{author}")
    public Book findByAuthor(@PathVariable String author) {
        Optional<Book> optBook = service.findByAuthor(author);

        if (optBook.isEmpty()) {
            throw new IllegalStateException("No Book with author: " + author);
        }

        return optBook.get();
    }

    @GetMapping("/title/{title}")
    public Book findByTitle(@PathVariable String title) {
        Optional<Book> optBook = service.findByTitle(title);

        if (optBook.isEmpty()) {
            throw new IllegalStateException("No Book with title: " + title);
        }

        return optBook.get();
    }
}
