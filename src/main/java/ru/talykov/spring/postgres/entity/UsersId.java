package ru.talykov.spring.postgres.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsersId implements Serializable {

  private Integer id;
  private String login;
}
