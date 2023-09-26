package com.example.bookstore.services.extra;

public class UnsuitableBookException extends RuntimeException {
    public UnsuitableBookException(String message) {
        super(message);
    }
}
