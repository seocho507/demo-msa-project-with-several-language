package com.seocho507.user.service;

import com.seocho507.user.domain.UserDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDomain loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
