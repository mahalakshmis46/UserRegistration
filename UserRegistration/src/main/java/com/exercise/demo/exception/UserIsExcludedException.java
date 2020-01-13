package com.exercise.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UserIsExcludedException extends Exception{

    private static final long serialVersionUID = 1L;

    
    public UserIsExcludedException(String message){
        super(message);
    }
}