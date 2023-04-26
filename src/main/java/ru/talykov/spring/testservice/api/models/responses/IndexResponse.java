package ru.talykov.spring.testservice.api.models.responses;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class IndexResponse {
    @SerializedName("request_headers")
    Map<String, String> requestHeaders;

    @SerializedName("request_method")
    String requestMethod;

    @SerializedName("status")
    String status;
}
