package com.seocho507.user.controller;

import com.seocho507.user.service.UserLoginService;
import com.seocho507.user.service.UserManageService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserLoginService userLoginService;
    private final UserManageService userManageService;

    public UserController(UserLoginService userLoginService, UserManageService userManageService) {
        this.userLoginService = userLoginService;
        this.userManageService = userManageService;
    }
}
