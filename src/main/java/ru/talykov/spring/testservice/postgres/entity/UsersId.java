package ru.talykov.spring.testservice.postgres.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UsersId implements Serializable {

    private Integer id;
    private String login;
}
