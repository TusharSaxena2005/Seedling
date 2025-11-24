package com.seedling.seedling.controllers;

import com.seedling.seedling.dto.UserDto;
import com.seedling.seedling.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/users/getAllUser")
    public ResponseEntity<List<UserDto>> getAllUser() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }
    
    @GetMapping("/users/getUser/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserById(id));
    }
    
    @GetMapping("/users/getUserByName/{name}")
    public ResponseEntity<List<UserDto>> getUserByName(@PathVariable String userName) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUserByName(userName));
    }
    
    @PostMapping("/users/createUser")
    public String createUser() {
        //UserDto userData = req.body();
        return "User created successfully";
    }
}
