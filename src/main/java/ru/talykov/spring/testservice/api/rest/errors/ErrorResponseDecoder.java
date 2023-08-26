package ru.talykov.spring.testservice.api.rest.errors;

import feign.Response;
import feign.codec.ErrorDecoder;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import ru.talykov.spring.testservice.api.models.responses.InternalErrorResponse;

import java.io.IOException;
import java.io.InputStream;

public class ErrorResponseDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        InternalErrorResponse errorResponse;

        try (InputStream bodyIs = response.body().asInputStream()) {
            errorResponse = mapper.readValue(bodyIs, InternalErrorResponse.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }

        return switch (response.status()) {
            case 400 ->
                    new Exception("Bad Request!!!1");
            case 500 ->
                    new ErrorResponseException(
                            errorResponse.getRequestHeaders(),
                            errorResponse.getRequestMethod(),
                            errorResponse.getStatus(),
                            response.status());
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
