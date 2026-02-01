package com.demo.play.dominio.repository;

import com.demo.play.dominio.dto.MovieDto;
import com.demo.play.dominio.dto.UpdateMovieDto;


import java.util.List;

public interface MovieRepository {
    List<MovieDto> getAll();
    MovieDto getById(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, UpdateMovieDto updateMovieDto);
    void delete(long id);
}


