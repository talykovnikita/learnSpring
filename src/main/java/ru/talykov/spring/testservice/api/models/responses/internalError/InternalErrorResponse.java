package ru.talykov.spring.testservice.api.models.responses.internalError;

import com.google.gson.annotations.SerializedName;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InternalErrorResponse {
    @SerializedName("request_headers")
    @JsonProperty("request_headers")
    Map<String, String> requestHeaders;

    @SerializedName("request_method")
    @JsonProperty("request_method")
    String requestMethod;

    @JsonProperty("status")
    @SerializedName("status")
    String status;
}