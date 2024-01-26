package com.book.bookApp.controllers;

import com.book.bookApp.models.Book;
import com.book.bookApp.models.BookDto;
import com.book.bookApp.service.BookService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService service;


    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<Book> create(@RequestBody BookDto dto){
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Book> getOne(@PathVariable UUID id){
        return service.getOne(id).map(book -> new ResponseEntity<>(book,HttpStatus.OK))
                .orElseThrow();
    }

    @PutMapping("/{id}")
    ResponseEntity<Book> update(@PathVariable UUID id, @RequestBody BookDto dto){
        return service.update(id,dto).map(book -> new ResponseEntity<>(book,HttpStatus.OK))
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
