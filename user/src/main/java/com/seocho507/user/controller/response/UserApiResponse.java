package com.seocho507.user.controller.response;

import org.springframework.http.HttpStatus;

public record UserApiResponse<T>(
        HttpStatus status,
        String message,
        T data
) {
}
