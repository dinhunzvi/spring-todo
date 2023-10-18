package com.example.todo.controller;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@CrossOrigin("*")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    // build add todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo =  todoService.addTodo(todoDto);

        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);

    }

    // build get todo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoId) {
        TodoDto todoDto = todoService.getTodo(todoId);

        return new ResponseEntity<>(todoDto, HttpStatus.OK);

    }

    // build get all todos REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getTodos() {
        List<TodoDto> todos = todoService.getAllTodos();

        // return ResponseEntity.ok(todos); alternative way of returning list of todos

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }
}
