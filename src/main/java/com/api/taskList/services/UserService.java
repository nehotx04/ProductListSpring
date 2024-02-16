package com.api.taskList.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.api.taskList.models.User;
import com.api.taskList.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Get user
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //Create User
    public User createUser(User user){
        return userRepository.save(user);
    }

    //Update User
    public User updateUser(User user){
        return userRepository.save(user);
    }

    //Delete User
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

}
