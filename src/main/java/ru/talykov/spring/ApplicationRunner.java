package ru.talykov.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories("ru.talykov.spring.testservice.postgres.repository")
@EntityScan("ru.talykov.spring.testservice.postgres.entity")
public class ApplicationRunner {


    public static void main(String[] args) {

        SpringApplication.run(ApplicationRunner.class, args);
    }
}
