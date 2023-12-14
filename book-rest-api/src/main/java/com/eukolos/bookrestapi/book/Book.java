package com.eukolos.bookrestapi.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UuidGenerator;


@Entity(name = "books")
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @UuidGenerator
    private String id;
    @Column(nullable = false)
    private String bookName;
    @Column(nullable = false)
    private String author;
    @NaturalId
    @Column(unique = true)
    private String isbn;
}
