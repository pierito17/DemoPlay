package com.demo.play.persistence.mapper;

import com.demo.play.dominio.dto.UpdateMovieDto;
import com.demo.play.persistence.entity.MovieEntity;
import com.demo.play.dominio.dto.MovieDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {GenreMapper.class,StateMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "stringToGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "clasificacion", target = "rating")
    @Mapping(source = "estado", target = "state",qualifiedByName = "stringToState")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);


    @InheritInverseConfiguration
    @Mappings({
            @Mapping(source = "genre", target = "genero", qualifiedByName = "genreToString"),
            @Mapping(target = "estado", ignore = true)
    })

    MovieEntity toEntity(MovieDto dto);


    @Mapping(target = "titulo", source = "title")
    @Mapping(target = "fechaEstreno", source = "releaseDate")
    @Mapping(target = "clasificacion", source = "rating")
    void updateEntityFromDto(UpdateMovieDto updateMovieDto, @MappingTarget MovieEntity movieEntity);
}







