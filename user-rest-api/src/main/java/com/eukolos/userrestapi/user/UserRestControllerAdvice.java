package com.eukolos.userrestapi.user;

import com.eukolos.userrestapi.client.ClientError;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class UserRestControllerAdvice {

    @Value("${user.sendreport.uri}")
    private String sendReportUri;
    @Value("${user.api.version}")
    private String currentApiVersion;

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<UserAppError> handleEntityNotFoundException(EntityNotFoundException ex) {
        final UserAppError error = new UserAppError(
                currentApiVersion,
                Integer.toString(HttpStatus.NOT_FOUND.value()),
                ex.getMessage(),
                "user-exceptions",
                "not-found exception because of missing user or wrong id",
                "something went wrong, please try again later",
                sendReportUri
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<UserAppError> handleBookNotFoundException(BookNotFoundException ex) {
        ClientError clientError = ex.getExceptionMessage();
        final UserAppError error = new UserAppError(
                clientError.getApiVersion(),
                Objects.requireNonNull(HttpStatus.resolve(Integer.parseInt(clientError.getError().getCode()))).toString(),
                clientError.getError().getMessage(),
                clientError.getError().getErrors().get(0).getDomain(),
                clientError.getError().getErrors().get(0).getReason(),
                clientError.getError().getErrors().get(0).getMessage(),
                clientError.getError().getErrors().get(0).getSendReport()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
