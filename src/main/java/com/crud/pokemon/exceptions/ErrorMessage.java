package com.crud.pokemon.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Date;

@ToString
@Getter
public class ErrorMessage {

    private String path;
    private String method;
    private int status;
    private String statusText;
    private Date timestamp;
    private String message;

    public ErrorMessage() {}

    public ErrorMessage(HttpServletRequest request, HttpStatus status, String message) {
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.status = status.value();
        this.statusText = status.getReasonPhrase();
        this.timestamp = new Date();
        this.message = message;
    }

}
