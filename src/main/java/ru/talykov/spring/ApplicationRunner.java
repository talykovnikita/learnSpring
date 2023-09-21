package ru.talykov.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ru.talykov.spring.postgres.repository.UsersRepository;

@SpringBootApplication
@EnableFeignClients
public class ApplicationRunner {

  public static void main(String[] args) {

    var ctx = SpringApplication.run(ApplicationRunner.class, args);
    UsersRepository ur = ctx.getBean(UsersRepository.class);
    System.out.println(ur.count());
  }
}
