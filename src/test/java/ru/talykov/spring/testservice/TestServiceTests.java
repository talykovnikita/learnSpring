package ru.talykov.spring.testservice;

import feign.Request.HttpMethod;
import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.talykov.spring.configurations.AbstractTest;
import ru.talykov.spring.testservice.enums.StatusEnum;

class TestServiceTests extends AbstractTest {

    @Test
    @DisplayName("Check configuration loading")
    @Description("Check, that testService 'url' and 'port' are loaded correct in configuration class")
    void loadConfigurationTest() {
        Assertions.assertThat(testServiceConfiguration.getUrl())
                .as("Адрес сервиса не совпал с ожидаемым")
                .isEqualTo("http://127.0.0.1");

        Assertions.assertThat(testServiceConfiguration.getPort())
                .as("Адрес сервиса не совпал с ожидаемым")
                .isEqualTo("80");
    }

    @Test
    @DisplayName("Check index response")
    @Description("Check response of index handler")
    void checkIndexResponseTest() {

        var expectedResponse = testServiceManager.buildIndexResponse(HttpMethod.POST, StatusEnum.WORKING);
        var resp = testServiceClient.postIndex();

        Assertions.assertThat(resp).as("Ответ не совпал с ожидаемым")
                .usingRecursiveComparison(new RecursiveComparisonConfiguration())
                .ignoringFields("requestHeaders")
                .isEqualTo(expectedResponse);
    }
}
