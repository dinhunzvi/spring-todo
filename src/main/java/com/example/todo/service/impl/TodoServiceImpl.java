package com.example.todo.service.impl;

import com.example.todo.dto.TodoDto;
import com.example.todo.entity.Todo;
import com.example.todo.exception.ResourceNotFoundException;
import com.example.todo.repository.TodoRepository;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // convert TodoDto into TodoJPA entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        // Todo JPA entity
        Todo savedTodo = todoRepository.save(todo);

        // convert saved Todo JPA entity object into TodoDto object

        return modelMapper.map(savedTodo, TodoDto.class);

    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException( "Todo with ID " + id + " not found" ));

        return modelMapper.map(todo,TodoDto.class);
    }
}
