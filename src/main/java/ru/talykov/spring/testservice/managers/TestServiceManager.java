package ru.talykov.spring.testservice.managers;

import feign.Request.HttpMethod;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;
import ru.talykov.spring.testservice.api.models.responses.index.IndexResponse;
import ru.talykov.spring.testservice.api.models.responses.internalError.InternalErrorResponse;
import ru.talykov.spring.testservice.api.models.responses.shared.enums.StatusEnum;

@Component
public class TestServiceManager {

    @Step("Build response of index method")
    public IndexResponse buildIndexResponse(HttpMethod httpMethod, StatusEnum statusEnum){

        return IndexResponse.builder()
                .requestMethod(httpMethod.name())
                .status(statusEnum.getStatus())
                .build();
    }

    @Step("Build response of internal-error-page method")
    public InternalErrorResponse buildInternalErrorPageResponse(HttpMethod httpMethod, StatusEnum statusEnum){

        return InternalErrorResponse.builder()
                .requestMethod(httpMethod.name())
                .status(statusEnum.getStatus())
                .build();
    }
}
