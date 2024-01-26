package com.book.bookApp.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "register_view_books")
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_book", nullable = false)
    private Book book;
    @Column(name = "counter")
    private Integer counterdb;
    @Column(name = "data_view")
    private LocalDate dateView;

    private static Integer counter = 0;

    public Register() {
    }

    public Register(Integer num) {
        counter = num;
        counter++;
        counterdb = counter;
        dateView = LocalDate.now();
    }

    public Register(UUID id, Book book) {
        this.id = id;
        this.book = book;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCounter() {
        return counter;
    }

    public static Integer setCounter(Integer counter) {
        Register.counter = counter;
        return counter;
    }

    public LocalDate getDateView() {
        return dateView;
    }

    public void setDateView(LocalDate dateView) {
        this.dateView = dateView;
    }

}
