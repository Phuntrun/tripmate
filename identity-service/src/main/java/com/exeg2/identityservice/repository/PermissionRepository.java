package com.exeg2.identityservice.repository;

import com.exeg2.identityservice.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}