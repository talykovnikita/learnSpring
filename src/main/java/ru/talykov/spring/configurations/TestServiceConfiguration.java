package ru.talykov.spring.configurations;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Data
@Slf4j
@Configuration
@EnableAspectJAutoProxy
@ConfigurationProperties(prefix = "test-service")
public class TestServiceConfiguration {

    String url;

    String port;

    @PostConstruct
    public void init() {
        log.warn(String.format("Test-service configuration '%s:%s' is loaded", this.url, this.port));
    }

}
