package com.eukolos.userrestapi.client;

import com.eukolos.userrestapi.dto.BookDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "book-service", path = "/api/v1/books")
public interface BookClient {

    @GetMapping
    ResponseEntity<List<BookDto>> findAll();
    @GetMapping("/name/{name}")
    ResponseEntity<BookDto> findByName(@PathVariable String name);

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookDto> findByIsbn(@PathVariable String isbn);

    @GetMapping("/{id}")
    ResponseEntity<BookDto> findById(@PathVariable String id);

    @PostMapping
    ResponseEntity<BookDto> save(@RequestBody BookDto bookDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable String id);


}