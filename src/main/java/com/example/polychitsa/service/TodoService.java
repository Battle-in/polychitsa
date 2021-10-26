package com.example.polychitsa.service;

import com.example.polychitsa.entity.TodoEntity;
import com.example.polychitsa.entity.UserEntity;
import com.example.polychitsa.model.User;
import com.example.polychitsa.repositories.TodoRepo;
import com.example.polychitsa.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public TodoEntity createTodo(TodoEntity todo, Long userId){
        UserEntity userEntity = userRepo.findById(userId).get();
        todo.setUser(userEntity);
        return todoRepo.save(todo);
    }

    public TodoEntity complete(Long id){
        TodoEntity todoEntity = todoRepo.findById(id).get();
        todoEntity.setCompleted(!todoEntity.getCompleted());
        return todoRepo.save(todoEntity);
    }

    public List<TodoEntity> getTodosByUserId(Long userId){
        return User.fromUserEntityTodo((UserEntity) userRepo.findById(userId).get());
    }

    public boolean deleteTodo(Long id){
        try {
            todoRepo.delete(todoRepo.findById(id).get());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
