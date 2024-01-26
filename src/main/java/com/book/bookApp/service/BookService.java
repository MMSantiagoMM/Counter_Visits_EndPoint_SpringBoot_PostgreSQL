package com.book.bookApp.service;

import com.book.bookApp.exceptions.BookNotFoundException;
import com.book.bookApp.mappers.BookMapper;
import com.book.bookApp.models.Book;
import com.book.bookApp.models.BookDto;
import com.book.bookApp.models.Register;
import com.book.bookApp.repositories.BookRepository;
import com.book.bookApp.repositories.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.book.bookApp.models.Register.setCounter;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final RegisterRepository registerRepository;


    public BookService(BookRepository bookRepository, BookMapper bookMapper, RegisterRepository registerRepository) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.registerRepository = registerRepository;
    }

    public Book create(BookDto dto){
        return bookRepository.save(bookMapper.toEntity(dto));
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> getOne(UUID id){

        if(bookRepository.existsById(id)){
                Integer num = setCounter(registerRepository.findByBook(bookRepository.findById(id)).size());
                Register register = new Register(num);
                register.setBook(bookRepository.findById(id).get());
                System.out.println(register.getBook().getTitle());
                System.out.println(register.getDateView());
                System.out.println(register.getCounter());
                registerRepository.save(register);
        }

        return Optional.of(bookRepository.findById(id))
                .orElseThrow(()-> new BookNotFoundException(id));
    }

    public Optional<Book> update (UUID id, BookDto dto){
        return Optional.of(bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(dto.getTitle());
                    book.setWriter(dto.getWriter());
                    book.setPublishingYear(dto.getPublishingYear());
                    return bookRepository.save(book);
                })).orElseThrow(()-> new BookNotFoundException(id));
    }

    public Boolean delete(UUID id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }


}
