package com.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    // Конструктор без аргументов — обязателен для JPA
    public TodoItem() {
    }

    public TodoItem(String s) {
    }

    public TodoItem(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
