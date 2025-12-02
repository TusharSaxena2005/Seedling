package com.seedling.seedling.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreateUserDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name should be of length 3 to 30 characters")
    private String userName;
    
    @Email
    @NotBlank(message = "Email is required")
    private String email;
    
    @NotBlank(message = "Mobile number is required")
    @Size(min = 10, max = 10, message = "Mobile number should be of length 10 characters")
    private Long mobileNumber;
    
    @NotBlank(message = "Date of birth is required")
    private LocalDate dob;
    
    @NotBlank(message = "Profession is required")
    private String profession;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 15, message = "Password should be of length 8 to 15 characters")
    private String password;
    
    private LocalDateTime createdAt;
}
