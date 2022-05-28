package com.example.market.controller;

import com.example.market.dto.request.AddUserRequest;
import com.example.market.dto.response.AddUserResponse;
import com.example.market.entity.Users;
import com.example.market.exception.CustomInvalidResponseException;
import com.example.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public AddUserResponse addUser(@Valid @RequestBody AddUserRequest addUserRequest) throws CustomInvalidResponseException {
        return userService.addUser(addUserRequest);
    }

    @PostMapping("/find-all")
    public List<Users> findAllUsers() {
        return userService.getAllUsers();
    }
}
