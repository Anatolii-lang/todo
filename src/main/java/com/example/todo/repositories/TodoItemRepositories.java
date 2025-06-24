package com.example.todo.repositories;

import com.example.todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepositories extends JpaRepository<TodoItem, Long> {
}
