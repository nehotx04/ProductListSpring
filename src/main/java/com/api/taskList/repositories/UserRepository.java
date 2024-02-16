package com.api.taskList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.taskList.models.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
