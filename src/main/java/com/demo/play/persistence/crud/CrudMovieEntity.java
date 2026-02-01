package com.demo.play.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import com.demo.play.persistence.entity.MovieEntity;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {
    MovieEntity findFirstByTitulo(String title);
}

