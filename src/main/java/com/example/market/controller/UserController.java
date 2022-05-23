package com.example.market.controller;

import com.example.market.entity.User;
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
    public User addUser(@Valid @RequestBody User user) throws CustomInvalidResponseException {
        User userDb = userService.findUserById(user.getUserId());
        if (userDb != null)
            throw new CustomInvalidResponseException("user already exists in db");
        return userService.addUser(user);
    }

    @PostMapping("/find-all")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }
}
