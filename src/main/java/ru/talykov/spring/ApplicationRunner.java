package ru.talykov.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApplicationRunner {


    public static void main(String[] args) {

        SpringApplication.run(ApplicationRunner.class, args);
    }
}
