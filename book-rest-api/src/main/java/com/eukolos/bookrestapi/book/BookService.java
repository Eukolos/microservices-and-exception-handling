package com.eukolos.bookrestapi.book;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Book findByName(String name) {
        return bookRepository.findByBookName(name).orElseThrow(() -> new EntityNotFoundException("Book not found!"));
    }

    public Book findById(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found!"));
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow(() -> new EntityNotFoundException("Book not found!"));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void deleteById(String id) {
        bookRepository.deleteById(id);
    }
}
