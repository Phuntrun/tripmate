package com.exeg2.identityservice.repository;

import com.exeg2.identityservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}