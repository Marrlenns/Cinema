package com.example.cinema.controllers;

import com.example.cinema.dto.director.DirectorDetailResponse;
import com.example.cinema.dto.director.DirectorRequest;
import com.example.cinema.dto.director.DirectorResponse;
import com.example.cinema.services.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/director")
public class DirectorController {

    private final DirectorService directorService;

    @PostMapping("/register")
    public String register(@RequestBody DirectorRequest directorRequest){
        directorService.register(directorRequest);
        return "Director: " + directorRequest.getFullname() + " - added successfully!";
    }

    @GetMapping("/all")
    public List<DirectorResponse> all(){
        return directorService.findAll();
    }

    @GetMapping("/{id}")
    public DirectorDetailResponse detail(@PathVariable Long id){
        return directorService.getById(id);
    }

}
