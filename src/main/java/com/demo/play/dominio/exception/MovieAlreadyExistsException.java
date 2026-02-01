package com.demo.play.dominio.exception;

public class MovieAlreadyExistsException extends RuntimeException{
    public MovieAlreadyExistsException(String movieTitle) {
        super("La movie ya existe en el sistema " + movieTitle);
    }
}
