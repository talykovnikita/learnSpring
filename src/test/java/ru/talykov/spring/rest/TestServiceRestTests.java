package ru.talykov.spring.rest;

import feign.Request.HttpMethod;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import ru.talykov.spring.shared.AbstractTest;
import ru.talykov.spring.testservice.api.models.responses.index.IndexResponse;
import ru.talykov.spring.testservice.api.models.responses.internalError.InternalErrorResponse;
import ru.talykov.spring.testservice.api.rest.errors.ErrorResponseException;
import ru.talykov.spring.testservice.api.models.responses.shared.enums.StatusEnum;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Epic("Spring examples")
@Feature("REST")
@Story("Making requests")
class TestServiceRestTests extends AbstractTest {

    @Test
    @DisplayName("Check GET index response")
    @Description("Check GET response of index handler")
    void checkGetIndexResponseTest() {
        IndexResponse actualResponse = testServiceApiClient.getIndex();
        IndexResponse expectedResponse = testServiceManager.buildIndexResponse(HttpMethod.GET, StatusEnum.WORKING);

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

    @Test
    @DisplayName("Check GET internal-error-page response")
    @Description("Check GET response of internal-error-page handler")
    void checkGetInternalErrorResponseTest() {

        ErrorResponseException actualException = assertThrows(ErrorResponseException.class, () -> {
            testServiceApiClient.getInternalErrorPage();
        });

        InternalErrorResponse expectedResponse = testServiceManager.buildInternalErrorPageResponse(HttpMethod.GET, StatusEnum.BROKEN);

        testServiceVerifier.assertInternalErrorResponse(expectedResponse, actualException);
        testServiceVerifier.assertStatusCode(actualException.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
