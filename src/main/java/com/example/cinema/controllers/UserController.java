package com.example.cinema.controllers;

import com.example.cinema.dto.user.UserRequest;
import com.example.cinema.dto.user.UserResponse;
import com.example.cinema.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRequest userRequest){
        userService.register(userRequest);
        return "User: " + userRequest.getNickname() + " - added successfully!";
    }

    @GetMapping("/all")
    public List<UserResponse> all(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse detail(@PathVariable Long id){
        return userService.getById(id);
    }
}
