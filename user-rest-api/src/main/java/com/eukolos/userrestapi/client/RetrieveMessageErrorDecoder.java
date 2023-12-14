package com.eukolos.userrestapi.client;

import com.eukolos.userrestapi.user.BookNotFoundException;
import com.google.gson.Gson;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
@RequiredArgsConstructor
public class RetrieveMessageErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String methodKey, Response response) {
        ClientError message;
        Gson gson = new Gson();
        try (InputStream body = response.body().asInputStream()){
            InputStreamReader reader = new InputStreamReader(body);
            message = gson.fromJson(reader, ClientError.class);

        } catch (IOException exception) {
            return new Exception("Unable to process error message", exception);
        }
        switch (response.status()) {
            case 404:
                return new BookNotFoundException(message);
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}