package com.example.market.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {

    @ApiModelProperty(value = "Arif")
    @JsonProperty(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "#Plotter@2")
    @JsonProperty(value = "password")
    private String password;

    @ApiModelProperty(value = "arif.ece.jmi@gmail.com")
    @JsonProperty(value = "email")
    private String email;

    @ApiModelProperty(value = "STUDENT")
    @JsonProperty(value = "role")
    private String role;

    @ApiModelProperty(value = "true")
    @JsonProperty(value = "is_account_not_expired")
    private Boolean isAccountNotExpired;

    @ApiModelProperty(value = "true")
    @JsonProperty(value = "is_account_non_locked")
    private Boolean isAccountNonLocked;

    @ApiModelProperty(value = "true")
    @JsonProperty(value = "is_credentials_non_expired")
    private Boolean isCredentialsNonExpired;

    @ApiModelProperty(value = "true")
    @JsonProperty(value = "is_enabled")
    private Boolean isEnabled;
}
