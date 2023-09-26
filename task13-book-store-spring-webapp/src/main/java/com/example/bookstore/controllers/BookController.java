package com.example.bookstore.controllers;

import com.example.bookstore.models.Book;
import com.example.bookstore.services.BookService;
import com.example.bookstore.services.extra.UnsuitableBookException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView getBooksList(ModelAndView model) {
        List<Book> books = bookService.getAllBooks();
        model.addObject("books", books);
//        model.addObject("listing", "all books");
        model.setViewName("listBooks");
        return model;
    }

    // List Filtered Books
    @GetMapping("/search")
    public ModelAndView searchBooks(@RequestParam("keyword") String keyword,
                                    ModelAndView model) {

        List<Book> books = bookService.searchBooks(keyword);
        model.addObject("books", books);
//        model.addObject("listing", "filtered books");
        model.setViewName("listBooks");
        return model;
    }

    //------------------------------------------------------------------------------

    // Add requests
    @GetMapping("/add")
    public ModelAndView getAddBookForm(ModelAndView model) {
        model.setViewName("addBookForm");
        return model;
    }

    @PostMapping("/add")
    public ModelAndView addNewBook(@ModelAttribute Book book,
                                   ModelAndView model) {

        try {
            bookService.addNewBook(book);
            model.setStatus(HttpStatus.OK);
            model.addObject("message", book.getBookName()
                    + " has been added successfully");
        } catch (ConstraintViolationException exception) {
            model.setStatus(HttpStatus.BAD_REQUEST);
            model.addObject("message", exception.getMessage());
        }

        model.addObject("action", "add");
        model.setViewName("confirmBookOperation");
        return model;
    }

    //-----------------------------------------------------------------------------------

    // Delete requests
    @GetMapping("/delete")
    public ModelAndView getDeleteBookForm(@ModelAttribute Book book,
                                   ModelAndView model) {

        model.addObject("iban", book.getIban());
        model.addObject("bookName", book.getBookName());
        model.setViewName("deleteBookForm");
        return model;
    }

    @PostMapping("/delete")
    public ModelAndView deleteBook(@ModelAttribute Book book,
                                   ModelAndView model) {

        try {
            bookService.deleteBook(book.getIban());
            model.setStatus(HttpStatus.OK);
            model.addObject("message", book.getBookName()
                    + " has been deleted successfully");
        } catch (UnsuitableBookException exception) {
            model.setStatus(HttpStatus.BAD_REQUEST);
            model.addObject("message", exception.getMessage());
        }

        model.addObject("action", "delete");
        model.setViewName("confirmBookOperation");
        return model;
    }

    //------------------------------------------------------------------------------------

    // Update requests
    @GetMapping("/update")
    public ModelAndView getUpdateBookForm(@ModelAttribute Book book,
                                          ModelAndView model) {

        model.addObject("iban", book.getIban());
        model.addObject("bookName", book.getBookName());
        model.addObject("authorName", book.getAuthorName());
        model.addObject("category", book.getCategory());
        model.addObject("price", book.getPrice());

        model.setViewName("updateBookForm");
        return model;
    }

    @PostMapping("/update")
    public ModelAndView updateBook(@ModelAttribute Book book,
                                   ModelAndView model) {

        try {
            bookService.updateBook(book);
            model.setStatus(HttpStatus.OK);
            model.addObject("message", book.getBookName()
                    + " was updated  successfully");
        } catch (ConstraintViolationException exception) {
            model.setStatus(HttpStatus.BAD_REQUEST);
            model.addObject("message", exception.getMessage());
        }

        model.addObject("action", "update");
        model.setViewName("confirmBookOperation");
        return model;
    }
}
