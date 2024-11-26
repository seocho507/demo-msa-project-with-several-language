package com.seocho507.user.domain;

import lombok.Getter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class UserDomain extends User {

    private final Long id;

    private final String username;

    @JsonIgnore
    private final String password;

    private final String email;

    private final String phone;

    private final String providerId;

    private String role;

    public UserDomain(Long id,
                      String username,
                      String password,
                      String email,
                      String phone,
                      String providerId,
                      String role,
                      Collection<? extends GrantedAuthority> authorities) {

        super(username, password, authorities);

        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.providerId = providerId;
        this.role = role;
    }
}
