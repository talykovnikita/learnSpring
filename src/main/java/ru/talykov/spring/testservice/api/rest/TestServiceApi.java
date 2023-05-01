package ru.talykov.spring.testservice.api.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.talykov.spring.testservice.api.models.responses.IndexResponse;

@FeignClient(name = "test-service")
public interface TestServiceApi {
    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
    IndexResponse getIndex();

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    IndexResponse postIndex();
}
