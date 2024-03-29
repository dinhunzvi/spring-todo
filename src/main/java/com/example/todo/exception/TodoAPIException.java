package com.example.todo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class TodoAPIException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

}
