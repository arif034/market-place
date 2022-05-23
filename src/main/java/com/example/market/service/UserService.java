package com.example.market.service;

import com.example.market.entity.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    List<User> getAllUsers();

    User findUserById(Long id);
}
