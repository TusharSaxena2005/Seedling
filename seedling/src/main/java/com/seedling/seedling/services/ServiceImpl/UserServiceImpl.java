package com.seedling.seedling.services.ServiceImpl;

import com.seedling.seedling.dto.UserDto;
import com.seedling.seedling.entity.UserEntity;
import com.seedling.seedling.repository.UserRepository;
import com.seedling.seedling.services.UserService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.seedling.seedling.dto.CreateUserDto ;

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
    
    @Override
    public UserDto createUser(CreateUserDto createUserDto){
        UserEntity userEntity = userRepository.save(modelMapper.map(createUserDto, UserEntity.class));
        return modelMapper.map(userEntity, UserDto.class);
    }
    
    @Override
    public UserDto updateUser(@org.jetbrains.annotations.NotNull java.util.Map<String, Object> updates) {
        String id = (String) updates.get("id");
        if (id == null || !ObjectId.isValid(id)) {
            throw new IllegalArgumentException("User id is invalid: " + id);
        }
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        updates.forEach((key, value) -> {
            switch (key) {
                case "userName" -> {
                    String v = requireString(key, value);
                    if (v.isBlank() || v.length() > 30 || v.length() < 3) throw new IllegalArgumentException("userName is invalid");
                    userEntity.setUserName(v.trim());
                }
                case "email" -> {
                    String v = requireString(key, value);
                    if (!isValidEmail(v)) throw new IllegalArgumentException("email is invalid");
                    userEntity.setEmail(v.trim().toLowerCase());
                }
                case "mobileNumber" -> {
                    Long mobile = parseMobileNumber(value);
                    userEntity.setMobileNumber(mobile);
                }
                
                case "dob" -> {
                    String v = requireString(key, value);
                    try {
                        java.time.LocalDate dob = java.time.LocalDate.parse(v);
                        if (dob.isAfter(java.time.LocalDate.now())) throw new IllegalArgumentException("dob cannot be in the future");
                        userEntity.setDob(dob);
                    } catch (java.time.format.DateTimeParseException ex) {
                        throw new IllegalArgumentException("dob must be in ISO format (yyyy-MM-dd)");
                    }
                }
                case "state" -> {
                    String v = requireString(key, value);
                    if (v.length() > 100) throw new IllegalArgumentException("state is too long");
                    userEntity.setState(v.trim());
                }
                case "district" -> {
                    String v = requireString(key, value);
                    if (v.length() > 100) throw new IllegalArgumentException("district is too long");
                    userEntity.setDistrict(v.trim());
                }
                case "miniBio" -> {
                    String v = requireString(key, value);
                    if (v.length() > 250) throw new IllegalArgumentException("miniBio is too long");
                    userEntity.setMiniBio(v.trim());
                }
                case "bio" -> {
                    String v = requireString(key, value);
                    if (v.length() > 2000) throw new IllegalArgumentException("bio is too long");
                    userEntity.setBio(v.trim());
                }
                case "profession" -> {
                    String v = requireString(key, value);
                    if (v.length() > 100) throw new IllegalArgumentException("profession is too long");
                    userEntity.setProfession(v.trim());
                }
                case "profileImageUrl" -> {
                    String v = requireString(key, value);
                    userEntity.setProfileImageUrl(v.trim());
                }
                case "password" -> {
                    String v = requireString(key, value);
                    if (v.length() < 8 || !v.matches(".*\\d.*") || !v.matches(".*[A-Za-z].*"))
                        throw new IllegalArgumentException("password must be at least 8 characters and contain letters and digits");
                    userEntity.setPassword(v);
                }
                default -> throw new IllegalArgumentException("Invalid field: " + key);
            }
        });
    
        UserEntity updatedUser = userRepository.save(userEntity);
        return modelMapper.map(updatedUser, UserDto.class);
    }
    
    @Override
    public void deleteUser(String id) {
        if (id == null || !ObjectId.isValid(id)) {
            throw new IllegalArgumentException("User id is invalid: " + id);
        }
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
        userRepository.delete(userEntity);
    }
    
    
    
    // helper methods (place inside the same class)
    private static String requireString(String key, Object value) {
        if (value == null) throw new IllegalArgumentException(key + " cannot be null");
        return value.toString();
    }
    
    private static boolean isValidEmail(String email) {
        if (email == null) return false;
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return java.util.regex.Pattern.compile(regex).matcher(email).matches();
    }
    
    @Contract("null -> fail")
    private static @NotNull Long parseMobileNumber(Object value) {
        if (value == null) throw new IllegalArgumentException("mobileNumber cannot be null");
        String s = value.toString().replaceAll("[^0-9]", "");
        if (s.isBlank()) throw new IllegalArgumentException("mobileNumber is invalid");
        if (s.length() != 10) throw new IllegalArgumentException("mobileNumber length is invalid");
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("mobileNumber is invalid");
        }
    }
}
