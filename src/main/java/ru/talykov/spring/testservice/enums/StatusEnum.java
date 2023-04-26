package ru.talykov.spring.testservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    WORKING("Is working!"), NOT_FOUND("Not found!"), BROKEN("Broken!");

    private final String status;
}
