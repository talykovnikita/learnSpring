package ru.talykov.spring.testservice.api.rest.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.talykov.spring.configuration.TestServiceClientConfiguration;
import ru.talykov.spring.testservice.api.models.responses.index.IndexResponse;

@FeignClient(name = "test-service", configuration = TestServiceClientConfiguration.class)
public interface TestServiceApi {
  @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
  IndexResponse getIndex();

  @GetMapping(
      value = "/internal-error-page",
      consumes = "application/json",
      produces = "application/json")
  IndexResponse getInternalErrorPage();

  @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
  IndexResponse postIndex();
}
