package de.school.project.bookservice.repository;

import de.school.project.bookservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthor(String author);
}
