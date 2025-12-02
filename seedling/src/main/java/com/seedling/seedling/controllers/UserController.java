package com.seedling.seedling.controllers;

import com.seedling.seedling.dto.CreateUserDto;
import com.seedling.seedling.dto.UserDto;
import com.seedling.seedling.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(createUserDto));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateProductPartially(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(updates));
    }
    
    @DeleteMapping("/users/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User deleted successfully");
    }
}
