package com.example.cinema.mappers.impl;

import com.example.cinema.dto.user.UserResponse;
import com.example.cinema.entities.User;
import com.example.cinema.mappers.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    public UserResponse toDto(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setNickname(user.getNickname());
        userResponse.setBirthDate(user.getBirthDate());
        return userResponse;
    }

    public List<UserResponse> toDtos(List<User> users){
        List<UserResponse> userResponseList = new ArrayList<>();
        for(User user: users) userResponseList.add(toDto(user));
        return  userResponseList;
    }
}
