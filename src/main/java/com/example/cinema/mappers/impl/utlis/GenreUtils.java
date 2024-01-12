package com.example.cinema.mappers.impl.utlis;

import com.example.cinema.dto.movie.genre.GenreResponse;
import com.example.cinema.entities.Genre;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreUtils {
    public GenreResponse toGenreDto(Genre genre){
        GenreResponse genreResponse = new GenreResponse();
        genreResponse.setType(genre.getType());
        return genreResponse;
    }

    public List<String> toGenreDtos(List<Genre> genres){
        List<String> genreResponseList = new ArrayList<>();
        for(Genre genre: genres)genreResponseList.add(genre.getType());
        return genreResponseList;
    }
}
