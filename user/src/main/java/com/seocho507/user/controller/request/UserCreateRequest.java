package com.seocho507.user.controller.request;

public record UserCreateRequest(
        String name,
        String email,
        String password
) {
}
