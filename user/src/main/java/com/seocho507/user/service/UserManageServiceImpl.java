package com.seocho507.user.service;

import com.seocho507.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserManageServiceImpl implements UserManageService {

    private final UserRepository userRepository;

    public UserManageServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
