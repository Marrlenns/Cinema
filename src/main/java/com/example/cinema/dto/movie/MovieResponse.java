package com.example.cinema.dto.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponse {
    private Long id;
    private String title;
    private String filmedDate;
}
