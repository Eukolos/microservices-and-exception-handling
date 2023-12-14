package com.eukolos.bookrestapi.book;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookRestControllerAdvice {

    @Value("${user.sendreport.uri}")
    private String sendReportUri;
    @Value("${user.api.version}")
    private String currentApiVersion;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<BookAppError> handleEntityNotFoundException(EntityNotFoundException ex) {
        final BookAppError error = new BookAppError(
                currentApiVersion,
                Integer.toString(HttpStatus.NOT_FOUND.value()),
                ex.getMessage(),
                "book-exceptions",
                "not-found exception because of missing user or wrong id",
                "something went wrong, please try again later",
                sendReportUri
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
