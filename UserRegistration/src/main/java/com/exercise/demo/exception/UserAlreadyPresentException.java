package com.exercise.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UserAlreadyPresentException extends Exception{

    private static final long serialVersionUID = 1L;

    public UserAlreadyPresentException(String message){
        super(message);
    }
}