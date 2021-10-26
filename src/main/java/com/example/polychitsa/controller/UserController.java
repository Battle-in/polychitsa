package com.example.polychitsa.controller;

import com.example.polychitsa.entity.UserEntity;
import com.example.polychitsa.repositories.UserRepo;
import com.example.polychitsa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity){
        try {
            userRepo.save(userEntity);
            return ResponseEntity.ok().body("{'status' : 'good'}");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("{'status' : 'bad'}");
        }
    }

    @GetMapping
    public User getUserById(@RequestParam(value = "id", required = true) Long id){
        try {
            return User.fromEntity(userRepo.findById(id).get());
        } catch (Exception e){
            e.printStackTrace();
            return new User();
        }
    }

}
