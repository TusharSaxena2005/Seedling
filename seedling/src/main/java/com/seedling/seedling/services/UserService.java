package com.seedling.seedling.services;

import com.seedling.seedling.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    
    UserDto getUserById(String id);
}
