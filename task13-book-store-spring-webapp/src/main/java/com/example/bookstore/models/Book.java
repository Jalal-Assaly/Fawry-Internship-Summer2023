package com.example.bookstore.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;


@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @Column(nullable = false)
    @Min(value = 1000000000000L, message = "Iban length is not 13 numbers")
    @Max(value = 9999999999999L, message = "Iban length is not 13 numbers")
    private Long iban;

    @Column(name = "book_name", nullable = false)
    @NotBlank(message = "Book name cannot be blank")
    @Size(max = 100, message = "Book name exceeded 100 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ,.!?']+$", message = "Book name cannot include special characters")
    private String bookName;

    @Column(name = "author_name", nullable = false)
    @NotBlank(message = "Author name cannot be blank")
    @Size(max = 100, message = "Author name exceeded 100 characters")
    @Pattern(regexp = "^[a-zA-Z .]+$", message = "Author name cannot include numeric or special characters")
    private String authorName;

    @Column(name = "category", nullable = false)
    @NotEmpty(message = "Category cannot be empty")
    @Pattern(regexp = "^(FICTION|MYSTERY|SCIENCE_FICTION|FANTASY|ROMANCE|HORROR|THRILLER|SELF_HELP|BIOGRAPHY|HISTORY|SCIENCE|COOKING|TRAVEL|POETRY|CHILDREN|OTHER)$",
            message = "Category does not exist")
    private String category;

    @Column
    @Min(value = 0, message = "Book price cannot be negative")
    @Max(value = 1000, message = "Book price cannot be above 1 thousand")
    private Double price;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "category", referencedColumnName = "category_name",
//            insertable = false, updatable = false)
//    private Category categoryObject;


    public Book(Long iban,
                String book_name,
                String author_name,
                String category,
                Double price) {

        this.iban = iban;
        this.bookName = book_name;
        this.authorName = author_name;
        this.category = category;
        this.price = price;
    }

    public Book() {

    }
}
