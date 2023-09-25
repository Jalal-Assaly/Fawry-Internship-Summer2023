package com.example.bookstore.dto;

import lombok.Data;

@Data
public class BookDTO {
    private Long iban;
    private String bookName;
    private String authorName;
    private String category;
    private Double price;
}
