package ru.talykov.spring.testservice.api.models.responses.index;

import com.google.gson.annotations.SerializedName;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class IndexResponse {
  @SerializedName("request_headers")
  @JsonProperty("request_headers")
  Map<String, String> requestHeaders;

  @SerializedName("request_method")
  @JsonProperty("request_method")
  String requestMethod;

  @SerializedName("status")
  @JsonProperty("status")
  String status;
}
