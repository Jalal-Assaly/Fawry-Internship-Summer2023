package com.example.bookstore.repositories;

import com.example.bookstore.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookByIban(Long iban);
    Optional<Book> findBookByBookName(String bookName);
    List<Book> findAllByBookNameContainingIgnoreCase(String bookName);
    List<Book> findAllByAuthorNameContainingIgnoreCase(String authorName);
    List<Book> findAllByCategoryIgnoreCase(String category);
}
