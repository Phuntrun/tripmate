package com.exeg2.identityservice.repository;

import com.exeg2.identityservice.model.InvalidToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidTokenRepository extends JpaRepository<InvalidToken, String> {
}