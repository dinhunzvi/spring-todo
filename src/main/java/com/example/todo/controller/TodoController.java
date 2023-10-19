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

    // build update todo REST API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId, @RequestBody TodoDto todoDto) {
        TodoDto updatedTodo = todoService.updateTodo(todoId, todoDto);

        return ResponseEntity.ok(updatedTodo);
    }

    // build delete todo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId) {
        todoService.deleteTodo(todoId);

        return ResponseEntity.ok("Todo successfully deleted");

    }

    // build complete todo REST API
    @PatchMapping("{id}")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId) {
        TodoDto updatedTodo = todoService.completeTodo(todoId);

        return ResponseEntity.ok(updatedTodo);

    }

    // build incomplete todo REST API
    @PatchMapping("{id}")
    public ResponseEntity<TodoDto> incompleteTodo(@PathVariable("id") Long todoId) {
        TodoDto updatedTodo = todoService.incompleteTodo(todoId);

        return ResponseEntity.ok(updatedTodo);

    }
}
