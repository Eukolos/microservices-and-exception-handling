package com.eukolos.userrestapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UuidGenerator;


@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;
    private String bookName;
    private String author;
    private String isbn;

}
