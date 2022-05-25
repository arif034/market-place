package com.example.market.auth;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.market.auth.ApplicationUserRole.STUDENT;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private static final String PASSWORD = "password";

    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(item -> item.getUsername().equals(username)).findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode(PASSWORD),
                        "annaSmith",
                        true,
                        true,
                        true,
                        true),

                new ApplicationUser(STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode(PASSWORD),
                        "linda",
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode(PASSWORD),
                        "tom",
                        true,
                        true,
                        true,
                        true)
        );
    }
}
