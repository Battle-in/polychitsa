package com.example.polychitsa.model;

import com.example.polychitsa.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public Todo() {
    }

    public static Todo fromEntity(TodoEntity todoEntity){
        Todo todo = new Todo();
        todo.setId(todoEntity.getId());
        todo.setTitle(todoEntity.getTitle());
        todo.setCompleted(todoEntity.getCompleted());
        return todo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
