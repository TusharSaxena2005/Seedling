package com.seedling.seedling.dto;


import com.seedling.seedling.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private UserDto author;
    private String createdAt;
    private String updatedAt;
}
