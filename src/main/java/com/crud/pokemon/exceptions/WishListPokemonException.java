package com.crud.pokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WishListPokemonException extends RuntimeException {

    public WishListPokemonException() {
        super("Try again later!");
    }

    public WishListPokemonException(String message) {
        super(message);
    }
}
