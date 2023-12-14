package com.eukolos.userrestapi.client;

import com.google.gson.Gson;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class RetrieveMessageErrorDecoder implements ErrorDecoder {


    private final ErrorDecoder errorDecoder = new Default();


    @Override
    public Exception decode(String methodKey, Response response) {
        ClientError message = null;
        Gson gson = new Gson();
        try (InputStream body = response.body().asInputStream()){
            message = gson.fromJson(new String(body.readAllBytes()), ClientError.class);



        } catch (IOException exception) {
            return new Exception(exception.getMessage());
        }
        switch (response.status()) {
            case 404:
                throw new BookNotFoundException(message);
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}