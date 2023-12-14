package com.eukolos.userrestapi.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserSeed implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args)  {
        User user1 = User.builder()
                .name("John")
                .email("eminaksoy35@gmail.com")
                .password(UUID.randomUUID().toString())
                .build();
        User user2 = User.builder()
                .name("Jane")
                .email("jane24@outlook.com")
                .password(UUID.randomUUID().toString())
                .build();
        User user3 = User.builder()
                .name("Jack")
                .email("jack@jack.com")
                .password(UUID.randomUUID().toString())
                .build();
        userRepository.saveAll(List.of(user1, user2, user3));
        log.warn(userRepository.findAll().toString());
    }
}
