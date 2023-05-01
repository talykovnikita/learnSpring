package ru.talykov.spring.rest;

import feign.Request.HttpMethod;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.talykov.spring.shared.AbstractTest;
import ru.talykov.spring.testservice.enums.StatusEnum;

@Epic("Spring examples")
@Feature("REST")
@Story("Making requests")
class TestServiceRestTests extends AbstractTest {

    @Test
    @DisplayName("Check GET index response")
    @Description("Check GET response of index handler")
    void checkGetIndexResponseTest() {
        var actualResponse = testServiceApiClient.getIndex();
        var expectedResponse = testServiceManager.buildIndexResponse(HttpMethod.GET, StatusEnum.WORKING);

        testServiceVerifier.assertIndexResponseIgnoreHeadersField(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("Check POST index response")
    @Description("Check POST response of index handler")
    void checkPostIndexResponseTest() {
        var actualResponse = testServiceApiClient.postIndex();
        var expectedResponse = testServiceManager.buildIndexResponse(HttpMethod.POST, StatusEnum.WORKING);

        testServiceVerifier.assertIndexResponseIgnoreHeadersField(expectedResponse, actualResponse);
    }
}
