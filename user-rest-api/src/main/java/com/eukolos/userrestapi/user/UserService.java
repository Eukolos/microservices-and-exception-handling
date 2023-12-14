package com.eukolos.userrestapi.user;

import com.eukolos.userrestapi.client.BookClient;
import com.eukolos.userrestapi.dto.BookDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BookClient bookClient;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found!"));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public User addBookToUser(String userId, String bookName) {
        User user = findById(userId);
        BookDto bookDto = bookClient.findByName(bookName).getBody();
        user.getIsbnList().stream().findAny().ifPresentOrElse(isbn -> {
            throw new IllegalArgumentException("User already has this book!");
        }, () -> {
            user.getIsbnList().add(Objects.requireNonNull(bookDto).getIsbn());
            userRepository.save(user);
        });
        return user;
    }
}
