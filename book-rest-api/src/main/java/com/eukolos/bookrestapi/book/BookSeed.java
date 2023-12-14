package com.eukolos.bookrestapi.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookSeed implements CommandLineRunner {
    private final BookRepository repository;

    @Override
    public void run(String... args)  {
        Book book = Book.builder()
                .bookName("The Lord of the Rings")
                .author("J. R. R. Tolkien")
                .isbn("978-3-16-148410-1")
                .build();
        Book book2 = Book.builder()
                .bookName("The Hobbit")
                .author("J. R. R. Tolkien")
                .isbn("978-3-16-148410-0")
                .build();
        Book book3 = Book.builder()
                .bookName("The Silmarillion")
                .author("J. R. R. Tolkien")
                .isbn("978-3-16-148410-2")
                .build();
        repository.saveAll(List.of(book, book2, book3));
        log.warn(repository.findAll().toString());
    }
}
