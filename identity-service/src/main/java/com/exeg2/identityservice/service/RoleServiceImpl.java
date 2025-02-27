package com.exeg2.identityservice.service;

import com.exeg2.identityservice.dto.request.RoleRequest;
import com.exeg2.identityservice.dto.response.RoleResponse;
import com.exeg2.identityservice.enums.ErrorCode;
import com.exeg2.identityservice.exception.AppException;
import com.exeg2.identityservice.mapper.RoleMapper;
import com.exeg2.identityservice.model.Role;
import com.exeg2.identityservice.repository.PermissionRepository;
import com.exeg2.identityservice.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;

    @Override
    public RoleResponse create(RoleRequest request) {
        Role role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        return roleMapper.toRoleResponse(roleRepository.save(role));
    }

    @Override
    public RoleResponse findOne(String id) {
        return roleMapper.toRoleResponse(roleRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND)));
    }

    @Override
    public List<RoleResponse> findAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    @Override
    public void delete(String id) {
        if (!roleRepository.existsById(id)) throw new AppException(ErrorCode.ROLE_NOT_FOUND);
        roleRepository.deleteById(id);
    }
}
