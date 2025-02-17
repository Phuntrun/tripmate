package com.exeg2.identityservice.mapper;

import com.exeg2.identityservice.dto.request.PermissionRequest;
import com.exeg2.identityservice.dto.response.PermissionResponse;
import com.exeg2.identityservice.model.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
