package com.example.market.service;

import com.example.market.dto.request.AddUserRequest;
import com.example.market.dto.response.AddUserResponse;
import com.example.market.entity.Users;
import com.example.market.exception.CustomInvalidResponseException;
import com.example.market.repository.UserRepository;
import com.example.market.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public AddUserResponse addUser(AddUserRequest addUserRequest) throws CustomInvalidResponseException {
        Users userDb = findByUsername(addUserRequest.getUserName());
        if (userDb != null)
            throw new CustomInvalidResponseException("user already exists in db");
        Users user = Users.builder()
                .email(addUserRequest.getEmail())
                .password(addUserRequest.getPassword())
                .isAccountNonLocked(addUserRequest.getIsAccountNonLocked())
                .isAccountNotExpired(addUserRequest.getIsAccountNotExpired())
                .userName(addUserRequest.getUserName())
                .isCredentialsNonExpired(addUserRequest.getIsCredentialsNonExpired())
                .isEnabled(addUserRequest.getIsEnabled())
                .role(addUserRequest.getRole())
                .build();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_" + user.getRole());
        userRepository.save(user);
        return AddUserResponse.builder()
                .currentServerTime(DateTimeUtil.getCurrentServerTime())
                .message("Success")
                .messageCode("AU-00001")
                .status(HttpStatus.OK.value())
                .userId(user.getUserId())
                .build();
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users findUserById(Long id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUserNameLike(username);
    }

}