package com.example.cinema.controllers;

import com.example.cinema.dto.movie.MovieDetailResponse;
import com.example.cinema.dto.movie.MovieRequest;
import com.example.cinema.dto.movie.MovieResponse;
import com.example.cinema.dto.movie.genre.GenreRequest;
import com.example.cinema.services.MovieService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    @PostMapping("/register")
    public String register(@RequestBody MovieRequest movieRequest){
        movieService.register(movieRequest);
        return "Movie: " + movieRequest.getTitle() + " - added successfully!";
    }

    @GetMapping("/all")
    public List<MovieResponse> all(){
        return movieService.all();
    }

    @GetMapping("/{id}")
    public MovieDetailResponse detail(@PathVariable Long id){
        return movieService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        movieService.deleteById(id);
        return "Movie deleted successfully!";
    }

    @PostMapping("/genre/new")
    public String newGenre(@RequestBody GenreRequest genreRequest){
        movieService.newGenre(genreRequest);
        return "New genre: " + genreRequest.getType() + " - added successfully!";
    }


}
