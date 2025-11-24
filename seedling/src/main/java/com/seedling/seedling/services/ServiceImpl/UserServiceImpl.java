package com.seedling.seedling.services.ServiceImpl;

import com.seedling.seedling.dto.UserDto;
import com.seedling.seedling.entity.UserEntity;
import com.seedling.seedling.repository.UserRepository;
import com.seedling.seedling.services.UserService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    
    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        if(users.isEmpty()) {
            throw new IllegalArgumentException("No users found");
        }
        return users
                .stream()
                .map(user -> modelMapper.map(users, UserDto.class))
                .collect(Collectors.toList());
    }
    
    @Override
    public UserDto getUserById(String id) {
        if(id == null || !ObjectId.isValid(id)) {
            throw new IllegalArgumentException("User id is invalid: " + id);
        }
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return modelMapper.map(userEntity, UserDto.class);
    }
    
    @Override
    public List<UserDto> getUserByName(String userName) {
        if(userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("User name is invalid: " + userName);
        }
        List<UserEntity> users = userRepository.findAllByNameContainingIgnoreCase(userName);
        if(users.isEmpty()) {
            throw new IllegalArgumentException("No users found with name containing: " + userName);
        }
        return users
                .stream()
                .map(user -> modelMapper.map(users, UserDto.class))
                .collect(Collectors.toList());
    }
    
}
