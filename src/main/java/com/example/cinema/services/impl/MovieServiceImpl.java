package com.example.cinema.services.impl;

import com.example.cinema.dto.movie.MovieDetailResponse;
import com.example.cinema.dto.movie.MovieRequest;
import com.example.cinema.dto.movie.MovieResponse;
import com.example.cinema.dto.movie.genre.GenreRequest;
import com.example.cinema.entities.Director;
import com.example.cinema.entities.Genre;
import com.example.cinema.entities.Movie;
import com.example.cinema.exceptions.BadRequestException;
import com.example.cinema.exceptions.NotFoundException;
import com.example.cinema.mappers.MovieMapper;
import com.example.cinema.repositories.DirectorRepository;
import com.example.cinema.repositories.GenreRepository;
import com.example.cinema.repositories.MovieRepository;
import com.example.cinema.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    private final MovieMapper movieMapper;
    private final GenreRepository genreRepository;

    private void addFilmToDirector(Director director, Movie movie){
        List<Movie> directorMovies = new ArrayList<>();
        if(director.getDirectorMovies() != null) directorMovies = director.getDirectorMovies();
        directorMovies.add(movie);
        director.setDirectorMovies(directorMovies);
        directorRepository.save(director);
    }

    @Override
    public void register(MovieRequest movieRequest){
        Movie movie = new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setFilmedDate(movieRequest.getFilmedDate());
        Optional<Director> director = directorRepository.findById(movieRequest.getDirectorId());
        if(director.isEmpty())
            throw new BadRequestException("Director with id: " + movieRequest.getDirectorId() + " - doesn't exist!");
        movie.setDirector(director.get());

        List<Long> genres = movieRequest.getGenres();
        List<Genre> movieGenres = new ArrayList<>();
        for(Long genreId: genres)
            if(genreRepository.findById(genreId).isPresent())
                movieGenres.add(genreRepository.findById(genreId).get());
        movie.setGenres(movieGenres);
        Movie newMovie =  movieRepository.saveAndFlush(movie);
        addFilmToDirector(director.get(), newMovie);
    }

    @Override
    public List<MovieResponse> all(){
        List<Movie> movies = movieRepository.findAll();
        return movieMapper.toDtos(movies);
    }

    @Override
    public MovieDetailResponse getById(Long id){
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isEmpty())
            throw new NotFoundException("Movie doesn't exist!", HttpStatus.NOT_FOUND);
        return movieMapper.toDetailDto(movie.get());
    }

    @Override
    public void newGenre(GenreRequest genreRequest){
        Genre genre = new Genre();
        genre.setType(genreRequest.getType());
        genreRepository.save(genre);
    }
}
