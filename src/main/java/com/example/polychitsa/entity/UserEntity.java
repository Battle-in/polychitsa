package com.example.polychitsa.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<TodoEntity> todoEntity;

    public List<TodoEntity> getTodoEntity() {
        return todoEntity;
    }

    public UserEntity() {
    }

    public void setTodoEntity(List<TodoEntity> todoEntity) {
        this.todoEntity = todoEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
