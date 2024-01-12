package com.example.cinema.mappers;

import com.example.cinema.dto.user.UserResponse;
import com.example.cinema.entities.User;

import java.util.List;

public interface UserMapper {
    List<UserResponse> toDtos(List<User> users);

    UserResponse toDto(User user);
}
