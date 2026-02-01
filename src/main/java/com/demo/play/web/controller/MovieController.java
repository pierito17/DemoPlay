package com.demo.play.web.controller;

import com.demo.play.dominio.dto.MovieDto;
import com.demo.play.dominio.dto.SuggestRequestDto;
import com.demo.play.dominio.dto.UpdateMovieDto;
import com.demo.play.dominio.service.DemoPlayAiService;
import com.demo.play.dominio.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/movies")
@Tag(name = "Movies", description = "Operarions about movies of DemoPlay")
public class MovieController {
    private final MovieService movieService;
    private final DemoPlayAiService demoPlayAiService;

    public MovieController(MovieService movieService, DemoPlayAiService demoPlayAiService) {
        this.movieService = movieService;
        this.demoPlayAiService = demoPlayAiService;
    }

    /*private final CrudMovieEntity crudMovieEntity;
    public MovieController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }
    @GetMapping("/movies")
    public List<MovieEntity> getAll() {
        return (List<MovieEntity>) this.crudMovieEntity.findAll();
    }*/

   /* @GetMapping
    public List<MovieDto> getAll() {
        return this.movieService.getAll();
    }*/


   /* @GetMapping("/{id}")
    public MovieDto getById(@PathVariable long id) {
        return this.movieService.getById(id);
    }*/

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtener una película por su identificador",
            description = "Retorna la película que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Película encontrada"),
                    @ApiResponse(responseCode = "404", description = "Película no encontrada", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getById(@Parameter(description = "Identificador de la película a recuperar", example = "9") @PathVariable long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody  MovieDto movieDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.add(movieDto));
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMovieSugestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.demoPlayAiService.generateMovieSugestion(suggestRequestDto.userPreferences()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id,@RequestBody @Valid UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        this.movieService.delete(id);
        return ResponseEntity.ok("Pelicula " + id + " eliminada con exito");

    }



}
