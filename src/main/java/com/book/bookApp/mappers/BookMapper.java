package com.book.bookApp.mappers;


import com.book.bookApp.models.Book;
import com.book.bookApp.models.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toEntity(BookDto dto);

    BookDto toDto(Book entity);



}
