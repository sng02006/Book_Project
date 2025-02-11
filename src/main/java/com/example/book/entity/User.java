package com.example.book.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String borrowBookTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    public User() {}

    public User(Long id, String userName, String borrowBookTitle, Book book) {
        this.id = id;
        this.userName = userName;
        this.borrowBookTitle = borrowBookTitle;
        this.book = book;
    }
}