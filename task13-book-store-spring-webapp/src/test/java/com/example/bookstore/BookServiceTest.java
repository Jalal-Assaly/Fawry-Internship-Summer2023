package com.example.bookstore;

import com.example.bookstore.models.Book;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    private List<Book> expectedBooks;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setupMockitoAnnotations() {
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void setupReadyDatabase() {
        expectedBooks = new ArrayList<>(List.of(
                new Book(8493088593859L,
                        "My Test Book",
                        "John Doe",
                        "SCIENCE",
                        43.50),
                new Book(5309854593859L,
                        "Testing The Mystery",
                        "Jane Doe",
                        "SCIENCE",
                        38.99),
                new Book(7325780495794L,
                        "Journey Around Testing",
                        "John Smith",
                        "FICTION",
                        25.60)));
    }



    @Test
    void injectedComponentsNotNull() {
        assertThat(bookRepository).isNotNull();
        assertThat(bookService).isNotNull();
    }

    @Test
    public void testGetAllBooks() {
        // Arrange
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        // Act
        List<Book> actualBooks = bookService.getAllBooks();

        // Assert
        assertThat(actualBooks).isEqualTo(expectedBooks);
    }

    @Test
    public void testSearchBooksByIban() {
        // Arrange
        when(bookRepository.findBookByIban(7325780495794L))
                .thenReturn(Optional.of(
                        new Book(7325780495794L,
                                "Journey Around Testing",
                                "John Smith",
                                "FICTION",
                                25.60)
                        ));

        // Act
        List<Book> foundBooks = bookService.searchBooks("7325780495794");

        // Assert
        assertThat(foundBooks)
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("Journey Around Testing"));
    }

    @Test
    public void testSearchBooksByString() {
        // Arrange
        when(bookRepository.findAllByBookNameContainingIgnoreCase("test")).thenReturn((expectedBooks));
        when(bookRepository.findAllByAuthorNameContainingIgnoreCase("test")).thenReturn((expectedBooks));
        when(bookRepository.findAllByCategoryIgnoreCase("test")).thenReturn((expectedBooks));

        // Act
        List<Book> foundBooks = bookService.searchBooks("test");

        // Assert
        assertThat(foundBooks)
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("My Test Book"))
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("Testing The Mystery"))
                .anyMatch(book -> book.getBookName().equalsIgnoreCase("Journey Around Testing"));
    }


    @Test
    void testAddNewBook() {
        // Arrange
        Book book = new Book(
                7325780495794L,
                "Journey Around Testing",
                "John Smith",
                "FICTION",
                25.60);

        when(bookRepository.save(book)).thenReturn(null);

        // Act
        bookService.addNewBook(book);

        // Assert
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testDeleteBook() {
        // Arrange
        Long iban = 123L;
        Book book = new Book(
                123L,
                "Testing Book",
                "Testing Author",
                "Engineering",
                13.0);

        when(bookRepository.findBookByIban(iban)).thenReturn(Optional.of(book));
        doNothing().when(bookRepository).deleteById(iban);

        // Act
        bookService.deleteBook(iban);

        // Assert
        verify(bookRepository, times(1)).deleteById(iban);
    }

//    @Test
//    public void testUpdateBook() {
//        // Arrange
//        Book existingBook = new Book(
//                34L,
//                "test",
//                "test",
//                "test",
//                1.0);
//        Book updatedBook = new Book(
//                123L,
//                "Testing Book",
//                "Testing Author",
//                "Engineering",
//                13.0);
//
//        when(bookRepository.findBookByIban(existingBook.getIban())).thenReturn(Optional.of(existingBook));
//        when(bookRepository.save(updatedBook)).thenReturn(null);
//
//        // Act
//        bookService.updateBook(updatedBook);
//
//        // Assert
////        verify(bookRepository, times(1)).save(updatedBook);
//        assertThat(existingBook.getIban()).isEqualTo(updatedBook.getIban());
//        assertThat(existingBook.getBookName()).isEqualTo(updatedBook.getBookName());
//        assertThat(existingBook.getAuthorName()).isEqualTo(updatedBook.getAuthorName());
//        assertThat(existingBook.getCategory()).isEqualTo(updatedBook.getCategory());
//        assertThat(existingBook.getPrice()).isEqualTo(updatedBook.getPrice());
//    }
}
