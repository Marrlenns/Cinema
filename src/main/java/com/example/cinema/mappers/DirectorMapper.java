package com.example.cinema.mappers;

import com.example.cinema.dto.director.DirectorDetailResponse;
import com.example.cinema.dto.director.DirectorResponse;
import com.example.cinema.entities.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorMapper {

    List<DirectorResponse> toDtos(List<Director> directors);

    DirectorDetailResponse toDetailDto(Director director);
}
