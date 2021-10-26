package com.example.polychitsa.controller;

import com.example.polychitsa.entity.TodoEntity;
import com.example.polychitsa.model.Todo;
import com.example.polychitsa.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId){
        try {
            return ResponseEntity.ok(Todo.fromEntity(todoService.createTodo(todo, userId)));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("{'status' : 'bad'}");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id){
        try {
            return ResponseEntity.ok(Todo.fromEntity(todoService.complete(id)));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("{'status' : 'bad'}");
        }
    }

    @GetMapping
    public ResponseEntity getTodos(@RequestParam Long userId){
        try {
            return ResponseEntity.ok().body(todoService.getTodosByUserId(userId));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @DeleteMapping
    public ResponseEntity deleteTodo(@RequestParam Long id){
        try {
            todoService.deleteTodo(id);
            return ResponseEntity.ok().body("");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
}
