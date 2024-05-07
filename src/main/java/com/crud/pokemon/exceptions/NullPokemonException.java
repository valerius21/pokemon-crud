package com.crud.pokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NullPokemonException extends RuntimeException {

    public NullPokemonException() {
        super("Pokemon doesn't exist in database!");
    }
    public NullPokemonException(String message) {
        super(message);
    }

}
