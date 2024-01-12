package com.example.cinema.services.impl;

import com.example.cinema.dto.director.DirectorDetailResponse;
import com.example.cinema.dto.director.DirectorRequest;
import com.example.cinema.dto.director.DirectorResponse;
import com.example.cinema.entities.Director;
import com.example.cinema.exceptions.NotFoundException;
import com.example.cinema.mappers.DirectorMapper;
import com.example.cinema.repositories.DirectorRepository;
import com.example.cinema.services.DirectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public void register(DirectorRequest directorRequest){
        Director director =  new Director();
        director.setFullname(directorRequest.getFullname());
        director.setBirthDate(directorRequest.getBirthDate());
        directorRepository.save(director);
    }

    @Override
    public List<DirectorResponse> findAll(){
        List<Director> directors = directorRepository.findAll();
        return directorMapper.toDtos(directors);
    }

    @Override
    public DirectorDetailResponse getById(Long id){
        Optional<Director> director = directorRepository.findById(id);
        if(director.isEmpty())
            throw new NotFoundException("Director doesn't exst!", HttpStatus.NOT_FOUND);
        return directorMapper.toDetailDto(director.get());
    }
}
