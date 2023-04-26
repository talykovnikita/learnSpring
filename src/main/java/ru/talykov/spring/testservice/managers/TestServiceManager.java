package ru.talykov.spring.testservice.managers;

import feign.Request.HttpMethod;
import io.qameta.allure.Step;
import org.springframework.stereotype.Component;
import ru.talykov.spring.testservice.api.models.responses.IndexResponse;
import ru.talykov.spring.testservice.enums.StatusEnum;

@Component
public class TestServiceManager {

    @Step("Build response of index method")
    public IndexResponse buildIndexResponse(HttpMethod httpMethod, StatusEnum statusEnum){

        return IndexResponse.builder()
                .requestMethod(httpMethod.name())
                .status(statusEnum.getStatus())
                .build();
    }
}
