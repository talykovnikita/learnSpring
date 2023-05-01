package ru.talykov.spring.configuration;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.talykov.spring.shared.AbstractTest;


@Epic("Spring examples")
@Feature("Configuration")
@Story("Loading")
class TestServiceConfigurationTests extends AbstractTest {
    @Test
    @DisplayName("Check testService url from configuration")
    @Description("Check that testService 'url' is loaded correct in configuration class")
    void loadUrlTest() {
        String expectedUrl = "http://127.0.0.1";
        testServiceConfigurationVerifier.assertConfigurationUrl(testServiceConfiguration, expectedUrl);
    }

    @Test
    @DisplayName("Check testService port from configuration")
    @Description("Check that testService 'port' is loaded correct in configuration class")
    void loadPortTest() {
        String expectedPort = "80";
        testServiceConfigurationVerifier.assertConfigurationPort(testServiceConfiguration, expectedPort);
    }
}
