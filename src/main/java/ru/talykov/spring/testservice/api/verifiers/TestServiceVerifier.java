package ru.talykov.spring.testservice.api.verifiers;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.springframework.stereotype.Component;
import ru.talykov.spring.testservice.api.models.responses.IndexResponse;

@Component
public class TestServiceVerifier {

    @Step("Verify index response without headers field")
    public void assertIndexResponseIgnoreHeadersField(IndexResponse expectedResponse, IndexResponse actualResponse){
        Assertions.assertThat(actualResponse).as("Actual response does not correspond expected one")
                .usingRecursiveComparison(new RecursiveComparisonConfiguration())
                .ignoringFields("requestHeaders")
                .isEqualTo(expectedResponse);
    }
}
