package com.example.bookstore.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    @Column(name = "author_name", nullable = false)
    private String authorName;

    @Column
    private Integer age;

    @Column
    private String genre;

//    @OneToMany(mappedBy = "authorName", fetch = FetchType.EAGER)
//    private List<Book> books;
}
