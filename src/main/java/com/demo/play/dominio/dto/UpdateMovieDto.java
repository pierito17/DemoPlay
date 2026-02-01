package com.demo.play.dominio.dto;



import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UpdateMovieDto(

        @NotBlank(message = "El titulo es obligatorio")
        String title,

        @PastOrPresent(message = "La fecha de lanzamiento debe anterior a la fecha actual")
        LocalDate releaseDate,

        @Min(value = 0, message = "El rating no puede ser menor que 0")
        @Max(value = 5, message = "El rating no puede ser mayor que 5")
        Double rating
) {
}
