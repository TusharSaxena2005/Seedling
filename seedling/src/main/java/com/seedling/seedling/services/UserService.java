package com.seedling.seedling.services;

import com.seedling.seedling.dto.CreateUserDto;
import com.seedling.seedling.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserDto> getAllUsers();
    
    UserDto getUserById(String id);
    
    List<UserDto> getUserByName(String userName);
    
    UserDto createUser(CreateUserDto createUserDto);
    
    UserDto updateUser(Map<String, Object> updates);
    
    void deleteUser(String id);
}
