package com.seocho507.user.config.security;

import com.seocho507.user.domain.UserDomain;
import com.seocho507.user.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtService jwtService;

    public Authentication getAuthentication(String accessToken) {
        UserDomain userDomain = jwtService.findUserByAccessToken(accessToken);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = List.of(new SimpleGrantedAuthority(userDomain.getRole()));
        UserDetails principal = new User(userDomain.getUsername(), userDomain.getPassword(), simpleGrantedAuthorities);
        return new UsernamePasswordAuthenticationToken(principal, userDomain.getId(), simpleGrantedAuthorities);
    }

    public String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (String) authentication.getCredentials();
    }

    public String getRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (String) authentication.getAuthorities().stream().findFirst().orElseThrow(RuntimeException::new).getAuthority();
    }
}