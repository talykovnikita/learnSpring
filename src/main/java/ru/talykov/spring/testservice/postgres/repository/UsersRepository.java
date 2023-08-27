package ru.talykov.spring.testservice.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.talykov.spring.testservice.postgres.entity.Users;
import ru.talykov.spring.testservice.postgres.entity.UsersId;

@Repository
@Transactional
public interface UsersRepository extends CrudRepository<Users, UsersId> {
    Users findByLogin(String login);
}