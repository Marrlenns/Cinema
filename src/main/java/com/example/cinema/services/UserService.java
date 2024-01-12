package com.example.cinema.services;

import com.example.cinema.dto.user.UserRequest;
import com.example.cinema.dto.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    void register(UserRequest userRequest);

    List<UserResponse> findAll();

    UserResponse getById(Long id);
}
