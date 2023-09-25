package com.example.bookstore;

import com.example.bookstore.models.Book;
import com.example.bookstore.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
//@ActiveProfiles("test")
//@AutoConfigureTestDatabase(
//        replace = AutoConfigureTestDatabase.Replace.NONE,
//        connection = EmbeddedDatabaseConnection.H2
//)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setupH2DatabaseContent() {
        // Arrange
        Book book1 = new Book(8493088593859L,
                "My Test Book",
                "John Doe",
                "SCIENCE",
                43.50);

        Book book2 = new Book(5309854593859L,
                "Testing The Mystery",
                "Jane Doe",
                "SCIENCE",
                38.99);

        Book book3 = new Book(7325780495794L,
                "Journey Around Testing",
                "John Smith",
                "FICTION",
                25.60);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
    }

    @Test
    void injectedComponentNotNull() {
        assertThat(bookRepository).isNotNull();
    }

    @Test
    void testFindBookByIban() {
        // Act
        Optional<Book> optionalBook = bookRepository.findBookByIban(8493088593859L);

        // Assert
        assertThat(optionalBook).isPresent();
        assertThat(optionalBook.get().getBookName()).isEqualTo("My Test Book");
    }

    @Test
    void testFindBookByBookName() {
        // Act
        Optional<Book> optionalBook = bookRepository.findBookByBookName("Testing The Mystery");

        // Assert
        assertThat(optionalBook).isPresent();
        assertThat(optionalBook.get().getIban()).isEqualTo(Long.valueOf("5309854593859"));
    }

    @Test
    void testFindAllByBookNameContainingIgnoreCase() {
        // Act
        List<Book> bookList = bookRepository.findAllByBookNameContainingIgnoreCase("test");

        // Assert
        assertThat(bookList).isNotEmpty();
        assertThat(bookList)
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("My Test Book"))
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("Testing The Mystery"))
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("Journey Around Testing"));
    }

    @Test
    void testFindAllByAuthorNameContainingIgnoreCase() {
        // Act
        List<Book> bookList = bookRepository.findAllByAuthorNameContainingIgnoreCase("john");

        // Assert
        assertThat(bookList).isNotEmpty();
        assertThat(bookList)
                .anyMatch(book -> book.getAuthorName().equalsIgnoreCase("John Doe"))
                .anyMatch(book -> book.getAuthorName().equalsIgnoreCase("John Smith"));
    }

    @Test
    void testFindAllByCategoryIgnoreCase() {
        // Act
        List<Book> bookList = bookRepository.findAllByCategoryIgnoreCase("science");

        // Assert
        assertThat(bookList).isNotEmpty();
        assertThat(bookList)
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("My Test Book"))
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("Testing The Mystery"));
    }
}
