package ru.talykov.spring.testservice.api.verifiers;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;
import ru.talykov.spring.configuration.TestServiceConfiguration;

@Component
public class TestServiceConfigurationVerifier {

  @Step("Verify test service URL from configuration is {expectedUrl}")
  public void assertConfigurationUrl(TestServiceConfiguration configuration, String expectedUrl) {
    Assertions.assertThat(configuration.getUrl())
        .as("Configuration URL does not correspond expected one")
        .isEqualTo(expectedUrl);
  }

  @Step("Verify test service port from configuration is {expectedPort}")
  public void assertConfigurationPort(TestServiceConfiguration configuration, String expectedPort) {
    Assertions.assertThat(configuration.getPort())
        .as("Configuration port does not correspond expected one")
        .isEqualTo(expectedPort);
  }
}
