package com.example.market.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "is_account_not_expired")
    private Boolean isAccountNotExpired;

    @Column(name = "is_account_non_locked")
    private  Boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired")
    private  Boolean isCredentialsNonExpired;

    @Column(name = "is_enabled")
    private  Boolean isEnabled;
}
