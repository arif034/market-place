package com.example.market.dto.response;

import com.example.market.util.ResponseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserResponse extends ResponseModel {

    @JsonProperty(value = "user_id")
    private Long userId;
}
