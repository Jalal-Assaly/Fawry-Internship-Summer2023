package com.example.bookstore.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column
    private String description;

//    @OneToMany(mappedBy = "category",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private List<Book> books;
}
