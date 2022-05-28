package com.example.market.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {

    @ApiModelProperty(value = "Mobile")
    @JsonProperty(value = "name")
    private String productName;

    @ApiModelProperty(value = "Electronics")
    @JsonProperty(value = "category")
    private String category;

    @ApiModelProperty(value = "12999.9")
    @JsonProperty(value = "price")
    private Double price;
}
