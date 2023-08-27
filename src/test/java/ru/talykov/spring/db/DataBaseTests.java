package ru.talykov.spring.db;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.talykov.spring.shared.AbstractTest;
import ru.talykov.spring.testservice.postgres.entity.UsersId;
import ru.talykov.spring.testservice.postgres.repository.UsersRepository;

class DataBaseTests extends AbstractTest {

    @Autowired
    protected UsersRepository usersRepository;

    @Test
    @DisplayName("Check user exist in database")
    void firstTest(){
        var userId = new UsersId(3, "ivan_ivanov");

        String msg = String.format("User with key %s is absent in database", userId);
        Assertions.assertThat(usersRepository.findByLogin(userId.getLogin()))
                .as(msg)
                .isNotNull();
    }
}
