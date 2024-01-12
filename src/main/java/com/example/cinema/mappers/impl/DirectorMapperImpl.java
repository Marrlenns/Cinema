package com.example.cinema.mappers.impl;

import com.example.cinema.dto.director.DirectorDetailResponse;
import com.example.cinema.dto.director.DirectorResponse;
import com.example.cinema.entities.Director;
import com.example.cinema.entities.Movie;
import com.example.cinema.mappers.DirectorMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DirectorMapperImpl implements DirectorMapper {

    private DirectorResponse toDto(Director director) {
        DirectorResponse directorResponse = new DirectorResponse();
        directorResponse.setId(director.getId());
        directorResponse.setFullname(director.getFullname());
        directorResponse.setBirthDate(director.getBirthDate());
        return directorResponse;
    }

    @Override
    public List<DirectorResponse> toDtos(List<Director> directors){
        List<DirectorResponse> directorResponseList= new ArrayList<>();
        for(Director director: directors) directorResponseList.add(toDto(director));
        return directorResponseList;
    }

    @Override
    public DirectorDetailResponse toDetailDto(Director director){
        DirectorDetailResponse directorDetailResponse = new DirectorDetailResponse();
        directorDetailResponse.setId(director.getId());
        directorDetailResponse.setFullname(director.getFullname());
        directorDetailResponse.setBirthDate(director.getBirthDate());
        List<Movie> movies = new ArrayList<>();
        if(director.getDirectorMovies() != null)
            movies.addAll(director.getDirectorMovies());

        directorDetailResponse.setMovies(movies);
        return directorDetailResponse;
    }
}
