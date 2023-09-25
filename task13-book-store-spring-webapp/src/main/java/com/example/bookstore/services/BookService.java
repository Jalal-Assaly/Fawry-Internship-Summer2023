package com.example.bookstore.services;

import com.example.bookstore.models.Book;
import com.example.bookstore.repositories.BookRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Validated
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> foundBooks = new ArrayList<>();

        try {
            Long keywordAsLong = Long.parseLong(keyword);
            Optional<Book> bookByIban = bookRepository.findBookByIban(keywordAsLong);

            if (bookByIban.isPresent()) {
                foundBooks.add(bookByIban.get());
            }

        } catch (NumberFormatException e) {
            // Search by string inputs
            List<Book> booksByBookName = bookRepository.findAllByBookNameContainingIgnoreCase(keyword);
            List<Book> booksByAuthorName = bookRepository.findAllByAuthorNameContainingIgnoreCase(keyword);
            List<Book> booksByCategory = bookRepository.findAllByCategoryIgnoreCase(keyword);

            foundBooks = Stream.of(booksByBookName, booksByAuthorName, booksByCategory)
                    .flatMap(List::stream)
                    .distinct()
                    .toList();
        }

        return foundBooks;
    }

    public void addNewBook(@Valid Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long iban) {
        Optional<Book> optionalBook = bookRepository.findBookByIban(iban);

        if (optionalBook.isPresent()) {
            bookRepository.deleteById(iban);
        }
    }

    public void updateBook(@Valid Book book) {
        Optional<Book> optionalBook = bookRepository.findBookByIban(book.getIban());

        if (optionalBook.isPresent()) {
            Book bookToUpdate = optionalBook.get();
            bookToUpdate.setBookName(book.getBookName());
            bookToUpdate.setAuthorName(book.getAuthorName());
            bookToUpdate.setCategory(book.getCategory());
            bookToUpdate.setPrice(book.getPrice());
            bookRepository.save(bookToUpdate);
        }
    }
}
