package com.example.todo.service.impl;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // convert TodoDto into TodoJPA entity
        Todo todo = new Todo();
        todo.setTitle( todoDto.getTitle());
        todo.setDescription( todoDto.getDescription());
        todo.setCompleted( todoDto.isCompleted());

        // Todo JPA entity
        Todo savedTodo = todoRepository.save(todo);

        // convert saved Todo JPA entity object into TodoDto object
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());

        return savedTodoDto;

    }
}
