package ru.talykov.spring.testservice.api.verifiers;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.springframework.stereotype.Component;
import ru.talykov.spring.testservice.api.models.responses.IndexResponse;
import ru.talykov.spring.testservice.api.models.responses.InternalErrorResponse;
import ru.talykov.spring.testservice.api.rest.errors.ErrorResponseException;

@Component
public class TestServiceVerifier {

    @Step("Verify index response without headers field")
    public void assertIndexResponseIgnoreHeadersField(IndexResponse expectedResponse, IndexResponse actualResponse){
        Assertions.assertThat(actualResponse).as("Actual response does not correspond expected one")
                .usingRecursiveComparison(new RecursiveComparisonConfiguration())
                .ignoringFields("requestHeaders")
                .isEqualTo(expectedResponse);
    }

    @Step("Verify internal-error response")
    public void assertInternalErrorResponse(InternalErrorResponse expectedResponse, ErrorResponseException responseException){
        InternalErrorResponse actualResponse = new InternalErrorResponse(
                responseException.getRequestHeaders(),
                responseException.getRequestMethod(),
                responseException.getStatus());

        Assertions.assertThat(actualResponse)
                .as("Actual response does not correspond expected one")
                .usingRecursiveComparison(new RecursiveComparisonConfiguration())
                .ignoringFields("requestHeaders")
                .isEqualTo(expectedResponse);
    }

    @Step("Verify status code")
    public void assertStatusCode(Integer actualStatusCode, Integer expectedStatusCode){
        Assertions.assertThat(actualStatusCode)
                .as("Actual status code does not correspond expected one")
                .usingRecursiveComparison(new RecursiveComparisonConfiguration())
                .isEqualTo(expectedStatusCode);
    }
}
