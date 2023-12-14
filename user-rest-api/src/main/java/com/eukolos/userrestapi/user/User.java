package com.eukolos.userrestapi.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "users")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @UuidGenerator
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> isbnList = new ArrayList<>();

}
