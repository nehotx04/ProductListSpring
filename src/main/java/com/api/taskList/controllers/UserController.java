package com.api.taskList.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.taskList.models.User;
import com.api.taskList.repositories.UserRepository;
import com.api.taskList.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // POST
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    // GET
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    // PUT
    @PutMapping("/edit/{id}")
    public User update(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        return userService.updateUser(user);
    }

    // DELETE
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user != null) {
            userService.deleteUserById(id);
            return "User Deleted Successfully";
        } else {
            return "User not found";
        }

    }

}
