package com.seocho507.user.controller.request;

public record UserLoginRequest(
        String email,
        String password
) {
}
