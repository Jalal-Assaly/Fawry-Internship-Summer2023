package com.example.bookstore.controllers;

import com.example.bookstore.models.Author;
import com.example.bookstore.models.Book;
import com.example.bookstore.services.AuthorService;
import com.example.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/home/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //---------------------------------------------------------------------------------

    // List All Books
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getBooksList() {
        List<Book> books = bookService.getAllBooks();
        return new ModelAndView(
                "listBooksPage",
                "books", books);
    }

    // List Filtered Books
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView searchBooks(@RequestParam("keyword") String keyword) {
        List<Book> books = bookService.searchBooks(keyword);
        return new ModelAndView(
                "listBooksPage",
                "books", books);
    }

    //------------------------------------------------------------------------------

    // Add requests
    @GetMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getAddBookForm() {
        return new ModelAndView("addBookForm");
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView addBook(@ModelAttribute Book book) {
        bookService.addBook(book);

        return new ModelAndView("confirmOperationPage",
                "message",
                book.getBookName() + " was added successfully");
    }

    //-----------------------------------------------------------------------------------

    // Delete requests
    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getDeleteBookForm(@ModelAttribute Book book) {
        return new ModelAndView("deleteBookForm",
                new HashMap<>() {{
                    put("iban", book.getIban());
                    put("bookName", book.getBookName());
                }}
        );
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ModelAndView deleteBook(@ModelAttribute Book book) {
        bookService.deleteBook(book.getIban());
        return new ModelAndView("confirmOperationPage",
                "message",
                book.getBookName() + " was deleted successfully");
    }

    //------------------------------------------------------------------------------------

    // Update requests
    @GetMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getUpdateBookForm(@ModelAttribute Book book) {
        return new ModelAndView(
                "updateBookForm",
                new HashMap<>() {{
                    put("iban", book.getIban());
                    put("bookName", book.getBookName());
                    put("authorName", book.getAuthorName());
                    put("category", book.getCategory());
                    put("price", book.getPrice());
                }}
        );
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView updateBook(@ModelAttribute Book book) {
        bookService.updateBook(book);
        return new ModelAndView("confirmOperationPage",
                "message",
                book.getBookName() + " has been updated successfully");
    }
}
