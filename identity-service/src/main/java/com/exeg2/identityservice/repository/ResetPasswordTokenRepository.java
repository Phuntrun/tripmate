package com.exeg2.identityservice.repository;

import com.exeg2.identityservice.model.ResetPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, String> {
}