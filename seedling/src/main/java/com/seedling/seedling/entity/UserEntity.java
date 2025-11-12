package com.seedling.seedling.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Update;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection="User")
public class UserEntity {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private LocalDate dob;
    private String state;
    private String district;
    private String miniBio;
    private String bio;
    private String category = "user";
    private String profession;
    private String profileImageUrl;
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}