package com.eukolos.bookrestapi.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService service;

    @GetMapping
    public List<Book> findAll() {
        log.warn(service.findAll().toString());
        return service.findAll();
    }

    @GetMapping("/name/{name}")
    public Book findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/isbn/{isbn}")
    public Book findByIsbn(@PathVariable String isbn) {
        return service.findByIsbn(isbn);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return service.save(book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }


}
