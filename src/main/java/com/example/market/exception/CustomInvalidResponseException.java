package com.example.market.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomInvalidResponseException extends Exception{

    @JsonProperty("message")
    private String message;
}
