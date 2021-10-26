package com.example.polychitsa.repositories;

import com.example.polychitsa.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
}
