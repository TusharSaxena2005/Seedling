package com.seedling.seedling.controllers;

import com.seedling.seedling.dto.UserDto;
import com.seedling.seedling.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/users/getAllUser")
    public List<UserDto> getAllUser() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/users/getUser/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }
}
