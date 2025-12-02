package com.seedling.seedling.dto;

import com.seedling.seedling.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private String userName;
    private String email;
    private Long mobileNumber;
    private LocalDate dob;
    private String state;
    private String district;
    private String miniBio;
    private String bio;
    private String category;
    private String profession;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
