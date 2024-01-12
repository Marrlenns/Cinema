package com.example.cinema.services.impl;

import com.example.cinema.dto.user.UserRequest;
import com.example.cinema.dto.user.UserResponse;
import com.example.cinema.entities.User;
import com.example.cinema.exceptions.NotFoundException;
import com.example.cinema.mappers.UserMapper;
import com.example.cinema.repositories.UserRepository;
import com.example.cinema.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void register(UserRequest userRequest){
        User user = new User();
        user.setNickname(userRequest.getNickname());
        user.setBirthDate(userRequest.getBirthDate());
        userRepository.save(user);
    }

    @Override
    public List<UserResponse> findAll(){
        List<User> users = userRepository.findAll();
        return userMapper.toDtos(users);
    }

    @Override
    public UserResponse getById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
            throw new NotFoundException("User doesn't exist", HttpStatus.NOT_FOUND);
        return userMapper.toDto(user.get());
    }
}
