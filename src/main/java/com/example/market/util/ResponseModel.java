package com.example.market.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"status", "current_server_time", "message", "response"})
public class ResponseModel implements Serializable {

    private int status;

    @JsonProperty("current_server_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String currentServerTime;

    private String message;

    private String messageCode;
}
