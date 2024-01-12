package com.example.cinema.services;

import com.example.cinema.dto.director.DirectorDetailResponse;
import com.example.cinema.dto.director.DirectorRequest;
import com.example.cinema.dto.director.DirectorResponse;

import java.util.List;

public interface DirectorService {
    void register(DirectorRequest directorRequest);

    List<DirectorResponse> findAll();

    DirectorDetailResponse getById(Long id);
}
