package com.example.market.auth;

import java.util.Optional;

public interface ApplicationUserDao {

     Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
