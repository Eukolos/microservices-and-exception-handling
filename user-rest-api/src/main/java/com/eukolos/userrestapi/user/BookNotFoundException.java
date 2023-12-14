package com.eukolos.userrestapi.user;

import com.eukolos.userrestapi.client.ClientError;
import lombok.Getter;

@Getter
public class BookNotFoundException extends RuntimeException {
    private final ClientError exceptionMessage;
    public BookNotFoundException(String message, ClientError exceptionMessage) {
        super(message);
        this.exceptionMessage = exceptionMessage;
    }

    public BookNotFoundException(ClientError message) {
        this.exceptionMessage = message;
    }

}
