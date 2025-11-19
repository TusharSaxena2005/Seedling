package com.seedling.seedling.services.ServiceImpl;

import com.seedling.seedling.dto.UserDto;
import com.seedling.seedling.entity.UserEntity;
import com.seedling.seedling.repository.UserRepository;
import com.seedling.seedling.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users
                .stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }
    
    @Override
    public UserDto getUserById(String id) {
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }
    
}
