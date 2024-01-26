package com.book.bookApp.repositories;

import com.book.bookApp.models.Book;
import com.book.bookApp.models.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RegisterRepository extends JpaRepository<Register, UUID> {
    List<Register> findByBook(Optional<Book> book);
}
