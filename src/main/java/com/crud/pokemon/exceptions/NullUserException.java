package com.crud.pokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NullUserException extends RuntimeException {

    public NullUserException() {
        super("User doesn't exist in database!");
    }
    public NullUserException(String message) {
        super(message);
    }

}
