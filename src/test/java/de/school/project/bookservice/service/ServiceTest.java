package de.school.project.bookservice.service;

import de.school.project.bookservice.model.Book;
import de.school.project.bookservice.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    @Test
    public void shouldFindAllBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("123", "book1", "author1"));
        books.add(new Book("456", "book2", "author2"));

        when(repository.findAll()).thenReturn(books);

        List<Book> result = service.findAll();

        assertEquals(books, result);

    }
}
