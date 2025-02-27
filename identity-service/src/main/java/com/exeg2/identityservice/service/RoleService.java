package com.exeg2.identityservice.service;

import com.exeg2.identityservice.dto.request.RoleRequest;
import com.exeg2.identityservice.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse create(RoleRequest request);
    RoleResponse findOne(String id);
    List<RoleResponse> findAll();
    void delete(String id);
}
