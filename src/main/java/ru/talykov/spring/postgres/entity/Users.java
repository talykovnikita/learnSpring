package ru.talykov.spring.postgres.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
@IdClass(UsersId.class)
public class Users {

  @Id
  @Column(name = "id")
  private Integer id;

  @Id
  @Column(name = "login")
  private String login;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "age", nullable = false)
  private Integer age;

  @Column(name = "dog_name")
  private String dogName;
}
