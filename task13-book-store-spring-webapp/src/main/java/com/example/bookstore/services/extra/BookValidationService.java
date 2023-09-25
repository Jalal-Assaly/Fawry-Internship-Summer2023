package com.example.bookstore.services.extra;

import com.example.bookstore.models.Book;
import com.example.bookstore.repositories.BookRepository;
import com.example.bookstore.services.extra.ValidationResult;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BookValidationService {

    private ValidationResult validateIbanLength(Long iban) {
        String ibanStr = String.valueOf(iban);

        if (ibanStr.length() == 13) {
            return ValidationResult.valid();
        } else {
            return ValidationResult.invalid("Iban length is not 13 numbers");
        }
    }

    //----------------------------------------------------------------------------------

    private ValidationResult validateBookNameUniqueness(BookRepository bookRepository, String bookName) {
        Optional<Book> optionalProduct = bookRepository.findBookByBookName(bookName);

        if (optionalProduct.isEmpty()) {
            return ValidationResult.valid();
        } else {
            return ValidationResult.invalid("Book already exists in the database");
        }
    }

    private ValidationResult validateStringLength(String bookName) {
        if (bookName.length() < 100) {
            return ValidationResult.valid();
        } else {
            return ValidationResult.invalid("Book name or Author name exceeded 100 characters");
        }
    }

    private ValidationResult validateBookNameFormat(String bookName) {
        String bookNameRegex = "^[a-zA-Z0-9 ,.!?]+$";

        if (bookName.matches(bookNameRegex)) {
            return ValidationResult.valid();
        } else {
            return ValidationResult.invalid("Book name cannot include special characters");
        }
    }

    private ValidationResult validateAuthorNameFormat(String authorName) {
        String authorNameRegex = "^[a-zA-Z ]+$";

        if (authorName.matches(authorNameRegex)) {
            return ValidationResult.valid();
        } else {
            return ValidationResult.invalid("Author name cannot include special characters or numbers");
        }
    }

    private ValidationResult validateBookCategory(String bookCategory) {
        final List<String> BOOK_CATEGORIES = Arrays.asList(
                "FICTION", "MYSTERY", "SCIENCE_FICTION", "FANTASY",
                "ROMANCE", "HORROR", "THRILLER", "SELF_HELP", "BIOGRAPHY", "HISTORY",
                "SCIENCE", "COOKING", "TRAVEL", "POETRY", "CHILDREN", "OTHER"
        );

        for (String validCategory : BOOK_CATEGORIES) {
            if (bookCategory.equals(validCategory)) {
                return ValidationResult.valid();
            }
        }
        return ValidationResult.invalid("Category does not exist");
    }

    public ValidationResult validatePositivePrice(Double price) {
        if (price > 0) {
            return ValidationResult.valid();
        } else {
            return ValidationResult.invalid("Book price cannot be negative");
        }
    }

    public ValidationResult validatePriceUnderMaximum(Double price) {
        if (price < 1000.00) {
            return ValidationResult.valid();
        } else {
            return ValidationResult.invalid("Book price cannot be above 1 thousand");
        }
    }


    public ValidationResult validateBook(BookRepository bookRepository, Book book) {

        Long iban = book.getIban();
        String bookName = book.getBookName();
        String authorName = book.getAuthorName();
        String category = book.getCategory();
        Double price = book.getPrice();

        boolean allValid = Stream.of(
                        validateIbanLength(iban),
                        validateBookNameFormat(bookName),
                        validateAuthorNameFormat(authorName),
                        validateStringLength(bookName),
                        validateStringLength(authorName),
                        validateBookCategory(category),
                        validatePositivePrice(price),
                        validatePriceUnderMaximum(price)
                )
                .allMatch(ValidationResult::isValid);

        if (allValid) {
            return ValidationResult.valid();
        } else {
            // If any validation fails, collect error messages
            List<String> errorMessages = Stream.of(
                            validateIbanLength(iban),
                            validateBookNameFormat(bookName),
                            validateAuthorNameFormat(authorName),
                            validateStringLength(bookName),
                            validateStringLength(authorName),
                            validateBookCategory(category),
                            validatePositivePrice(price),
                            validatePriceUnderMaximum(price)
                    )
                    .filter(result -> !result.isValid())
                    .map(ValidationResult::getErrorMessage)
                    .toList();

            // Return the first error message, you can change this logic if needed
            return ValidationResult.invalid(errorMessages.get(0));
        }
    }

}