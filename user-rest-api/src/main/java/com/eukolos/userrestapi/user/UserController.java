package com.eukolos.userrestapi.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public List<User> findAll() {
        log.warn(service.findAll().toString());
        return service.findAll();
    }

    @GetMapping("/name/{name}")
    public User findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping("/{userId}/books/{bookId}")
    public User addBookToUser(@PathVariable String userId, @PathVariable String bookId) {
        return service.addBookToUser(userId, bookId);
    }


}
