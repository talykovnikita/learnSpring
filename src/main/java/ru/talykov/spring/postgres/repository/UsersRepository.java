package ru.talykov.spring.postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.talykov.spring.postgres.entity.Users;
import ru.talykov.spring.postgres.entity.UsersId;

@Repository
public interface UsersRepository extends CrudRepository<Users, UsersId> {}
