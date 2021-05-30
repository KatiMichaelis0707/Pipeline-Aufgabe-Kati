package de.school.project.bookservice.service;

import de.school.project.bookservice.model.Book;
import de.school.project.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Optional<Book> findById(String id) {
        return repository.findById(id);
    }

    public Optional<Book> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Optional<Book> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(String id, Book book) {
        Optional<Book> optionalBook = repository.findById(id);

        if (optionalBook.isEmpty()) {
            throw new IllegalStateException("No Book with ID: " + id);
        }

        Book bookFromDb = optionalBook.get();

        bookFromDb.setAuthor(book.getAuthor());
        bookFromDb.setTitle(book.getTitle());

        repository.save(bookFromDb);

        return findById(id).get();
    }

    public Book deleteBook(String id) {
        Optional<Book> optionalBook = repository.findById(id);

        if (optionalBook.isEmpty()) {
            throw new IllegalStateException("No Book with ID: " + id);
        }

        Book book = optionalBook.get();

        repository.deleteById(id);

        return book;
    }
}
