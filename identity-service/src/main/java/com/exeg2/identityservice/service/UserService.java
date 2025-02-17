package com.exeg2.identityservice.service;

import com.exeg2.identityservice.dto.request.UserCreateRequest;
import com.exeg2.identityservice.dto.request.UserUpdateRequest;
import com.exeg2.identityservice.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserCreateRequest userCreateRequest);
    UserResponse findUserById(String id);
    List<UserResponse> findAllUsers();
    UserResponse updateUser(String id, UserUpdateRequest request);
    void deleteUser(String id);
    UserResponse myinfo();
}
