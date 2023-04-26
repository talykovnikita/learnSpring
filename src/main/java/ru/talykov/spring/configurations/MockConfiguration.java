package ru.talykov.spring.configurations;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Slf4j
@Configuration
public class MockConfiguration {

    @Value("${mock.url}")
    String url;

    @Value("${mock.port}")
    String port;

    @Value("${mock.test-path-1}")
    String testPath1;

    @Value("${mock.test-path-2}")
    String testPath2;

    @PostConstruct
    public void init() {
        log.warn(String.format("Mock configuration '%s:%s' is loaded", this.url, this.port));
    }
}
