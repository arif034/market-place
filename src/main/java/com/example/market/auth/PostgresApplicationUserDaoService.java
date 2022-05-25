package com.example.market.auth;

import com.example.market.entity.User;
import com.example.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

import static com.example.market.auth.ApplicationUserRole.ADMIN;
import static com.example.market.auth.ApplicationUserRole.STUDENT;

@Repository("postgres")
public class PostgresApplicationUserDaoService implements ApplicationUserDao{

    private final UserRepository userRepository;

    @Autowired
    public PostgresApplicationUserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        User user = userRepository.findByUserName(username);
        return Optional.of(new ApplicationUser(getAuthorities(user.getRole()),
                user.getPassword(),
                user.getUserName(),
                user.getIsAccountNotExpired(),
                user.getIsAccountNonLocked(),
                user.getIsCredentialsNonExpired(),
                user.getIsEnabled()
        ));
    }

    private Set<SimpleGrantedAuthority> getAuthorities(String role)
    {
        if(role.substring(5).equals("STUDENT"))
            return STUDENT.getGrantedAuthorities();
        if(role.substring(5).equals("ADMIN"))
            return ADMIN.getGrantedAuthorities();
        return null;
    }
}
