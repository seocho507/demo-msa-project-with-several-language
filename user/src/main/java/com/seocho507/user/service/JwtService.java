package com.seocho507.user.service;

import com.seocho507.user.domain.UserDomain;

public interface JwtService {
    UserDomain findUserByAccessToken(String accessToken);

    Boolean validateToken(String token);
}
