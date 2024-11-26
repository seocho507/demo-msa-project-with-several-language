package com.seocho507.user.repository;

import com.seocho507.user.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {


    @Query("SELECT new com.seocho507.user.domain.UserDomain(u.id, u.username, u.password, u.email, u.phone, u.providerId) FROM UserEntity u WHERE u.providerId = :providerId")
    UserDomain findByProviderId(String providerId);
}
