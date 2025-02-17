package com.exeg2.identityservice.mapper;

import com.exeg2.identityservice.dto.request.UserCreateRequest;
import com.exeg2.identityservice.dto.request.UserUpdateRequest;
import com.exeg2.identityservice.dto.response.UserResponse;
import com.exeg2.identityservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);

    UserResponse toUserResponse(User user);
    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
