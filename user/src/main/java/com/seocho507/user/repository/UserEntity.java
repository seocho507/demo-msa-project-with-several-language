package com.seocho507.user.repository;

import jakarta.persistence.*;
import lombok.Getter;


@Table(name = "users")
@Getter
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String providerId;
}
