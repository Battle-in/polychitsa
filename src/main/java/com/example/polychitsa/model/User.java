package com.example.polychitsa.model;

import com.example.polychitsa.entity.TodoEntity;
import com.example.polychitsa.entity.UserEntity;

import javax.persistence.OneToMany;
import java.util.List;

public class User {
    private Long id;
    private String login;
    private String password;

    private List<TodoEntity> todoEntity;

    public User() {
    }

    public static User fromEntity(UserEntity userEntity){
        User user = new User();
        user.setId(userEntity.getId());
        user.setLogin(userEntity.getLogin());
        user.setPassword(userEntity.getPassword());
        List<TodoEntity> newTodoEn = userEntity.getTodoEntity();
        TodoEntity tempTodoEntity = new TodoEntity();
        for (int i = 0; i < newTodoEn.size(); i++) {
            tempTodoEntity = newTodoEn.get(i);
            tempTodoEntity.setUser(null);
            newTodoEn.set(i, tempTodoEntity);
        }
        user.setTodoEntity(userEntity.getTodoEntity());
        return user;
    }

    public static List<TodoEntity> fromUserEntityTodo(UserEntity userEntity){
        List<TodoEntity> newTodoEntity = userEntity.getTodoEntity();
        TodoEntity tempTodoEntity = new TodoEntity();
        for (int i = 0; i < newTodoEntity.size(); i++) {
            tempTodoEntity = newTodoEntity.get(i);
            tempTodoEntity.setUser(null);
            newTodoEntity.set(i, tempTodoEntity);
        }
        return newTodoEntity;
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

    public List<TodoEntity> getTodoEntity() {
        return todoEntity;
    }

    public void setTodoEntity(List<TodoEntity> todoEntity) {
        this.todoEntity = todoEntity;
    }
}
