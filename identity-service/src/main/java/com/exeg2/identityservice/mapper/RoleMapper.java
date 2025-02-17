package com.exeg2.identityservice.mapper;

import com.exeg2.identityservice.dto.request.RoleRequest;
import com.exeg2.identityservice.dto.response.RoleResponse;
import com.exeg2.identityservice.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
