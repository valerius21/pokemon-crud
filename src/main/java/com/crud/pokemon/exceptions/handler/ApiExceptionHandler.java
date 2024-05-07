package com.crud.pokemon.exceptions.handler;

import com.crud.pokemon.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiExceptionHandler {

    @ExceptionHandler({
            EntityNotFoundException.class,
            NullPokemonException.class,
            NullUserException.class

    })
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(
            EntityNotFoundException ex, HttpServletRequest request
    ) {
      log.error("API Error - ", ex);
      return ResponseEntity
              .status(HttpStatus.NOT_FOUND)
              .contentType(MediaType.APPLICATION_JSON)
              .body(new ErrorMessage(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(
            IllegalArgumentException ex, HttpServletRequest request
    ) {
        log.error("API Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex, HttpServletRequest request, BindingResult result
    ) {
        log.error("API Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Invalid arguments!", result));
    }

    @ExceptionHandler(UserRegisteredException.class)
    public ResponseEntity<ErrorMessage> handleUserRegisteredException(
            UserRegisteredException ex, HttpServletRequest request
    ) {
        log.error("API Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(WishListPokemonException.class)
    public ResponseEntity<ErrorMessage> handleWishListPokemonException(
            WishListPokemonException ex, HttpServletRequest request
    ) {
        log.error("API Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    @ExceptionHandler(StringIndexOutOfBoundsException.class)
    private ResponseEntity<ErrorMessage> handleStringIndexOutOfBoundsHandler(
            StringIndexOutOfBoundsException ex, HttpServletRequest request
    ) {

        log.error("API Error - ", ex);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(request, HttpStatus.BAD_REQUEST, ex.getMessage()));
    }
}
