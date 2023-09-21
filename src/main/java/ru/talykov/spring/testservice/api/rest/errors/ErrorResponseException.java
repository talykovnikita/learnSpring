package ru.talykov.spring.testservice.api.rest.errors;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ErrorResponseException extends RuntimeException {
  private final Map<String, String> requestHeaders;
  private final String requestMethod;
  private final String status;
  private final Integer statusCode;
}
