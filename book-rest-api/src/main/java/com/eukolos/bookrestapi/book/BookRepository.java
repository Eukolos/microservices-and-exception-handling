package com.eukolos.bookrestapi.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String> {
    Optional<Book> findByBookName(String bookName);
    Optional<Book> findByIsbn(String isbn);
}
