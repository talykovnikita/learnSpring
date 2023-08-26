package ru.talykov.spring.configurations;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.talykov.spring.testservice.api.rest.errors.ErrorResponseDecoder;

@Configuration
public class TestServiceClientConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ErrorResponseDecoder();
    }
}
