package com.crud.pokemon.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class WrongMatchPasswordUsernameException extends RuntimeException {

    public WrongMatchPasswordUsernameException() {
        super("The username or password is incorrect!");
    }

    public WrongMatchPasswordUsernameException(String message) {
        super(message);
    }
}
