package ru.talykov.spring.testservice.api.rest.clients;

import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.talykov.spring.testservice.api.models.responses.index.IndexResponse;
import ru.talykov.spring.testservice.api.rest.api.TestServiceApi;

@Component
public class TestServiceApiClient {

    @Autowired
    TestServiceApi testServiceApi;

    @Step("Make GET index request")
    public IndexResponse getIndex() {return testServiceApi.getIndex();}

    @Step("Make GET internal-error-page request")
    public IndexResponse getInternalErrorPage() {return testServiceApi.getInternalErrorPage();}

    @Step("Make POST index request")
    public IndexResponse postIndex() {
        return testServiceApi.postIndex();
    }
}
