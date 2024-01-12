package com.example.cinema.dto.movie;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieRequest {
    private String title;
    private String description;
    private String filmedDate;
    private Long directorId;
    private List<Long> genres;
}
