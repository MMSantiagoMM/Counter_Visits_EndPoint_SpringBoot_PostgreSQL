package com.book.bookApp.models;

import java.time.LocalDate;

public class BookDto {

    private String title;
    private String writer;
    private LocalDate publishingYear;

    public BookDto() {
    }

    public BookDto(String title, String writer, LocalDate publishingYear) {
        this.title = title;
        this.writer = writer;
        this.publishingYear = publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDate getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(LocalDate publishingYear) {
        this.publishingYear = publishingYear;
    }
}
