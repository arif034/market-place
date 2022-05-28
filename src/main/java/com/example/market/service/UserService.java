package com.example.market.service;

import com.example.market.dto.request.AddUserRequest;
import com.example.market.dto.response.AddUserResponse;
import com.example.market.entity.Users;
import com.example.market.exception.CustomInvalidResponseException;

import java.util.List;

public interface UserService {

    AddUserResponse addUser(AddUserRequest addUserRequest) throws CustomInvalidResponseException;

    List<Users> getAllUsers();

    Users findUserById(Long id);

    Users findByUsername(String username );
}
