package ru.talykov.spring.testservice.api.rest;

import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.talykov.spring.testservice.api.models.responses.IndexResponse;

@Component
public class TestServiceApiClient {

    @Autowired
    TestServiceApi testServiceApi;

    @Step("Make GET index request")
    public IndexResponse getIndex() {
        return testServiceApi.getIndex();
    }

    @Step("Make POST index request")
    public IndexResponse postIndex() {
        return testServiceApi.postIndex();
    }
}
