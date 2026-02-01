package com.demo.play.dominio.dto;

import java.time.LocalDate;
import com.demo.play.dominio.Genre;
import com.demo.play.persistence.mapper.StateMapper;

public record MovieDto(
        Long id,
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        String state
) {
}
