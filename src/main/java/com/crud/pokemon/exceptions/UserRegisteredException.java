package com.crud.pokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserRegisteredException extends RuntimeException {

    public UserRegisteredException() {
        super("User already registered!");
    }
    public UserRegisteredException(String message) {
        super(message);
    }

}
