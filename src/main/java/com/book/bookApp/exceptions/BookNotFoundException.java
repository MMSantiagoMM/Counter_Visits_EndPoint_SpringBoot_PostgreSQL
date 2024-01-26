package com.book.bookApp.exceptions;

import java.util.UUID;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(UUID id){
        super("The book with the id: " + id + "was not found");
    }

}
