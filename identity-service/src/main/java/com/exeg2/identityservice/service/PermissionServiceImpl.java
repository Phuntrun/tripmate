package com.exeg2.identityservice.service;

import com.exeg2.identityservice.dto.request.PermissionRequest;
import com.exeg2.identityservice.dto.response.PermissionResponse;
import com.exeg2.identityservice.enums.ErrorCode;
import com.exeg2.identityservice.exception.AppException;
import com.exeg2.identityservice.mapper.PermissionMapper;
import com.exeg2.identityservice.model.Permission;
import com.exeg2.identityservice.repository.PermissionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImpl implements PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        return permissionMapper.toPermissionResponse(permissionRepository.save(permission));
    }

    @Override
    public PermissionResponse findByName(String name) {
        return permissionMapper.toPermissionResponse(permissionRepository.findById(name).orElseThrow(() -> new AppException(ErrorCode.PERMISSION_NOT_FOUND)));
    }

    @Override
    public List<PermissionResponse> findAll() {
        return permissionRepository.findAll().stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public void delete(String name) {
        if (permissionRepository.findById(name).isEmpty()) throw new AppException(ErrorCode.PERMISSION_NOT_FOUND);
        permissionRepository.deleteById(name);
    }
}
