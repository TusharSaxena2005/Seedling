package com.seedling.seedling.dto;


import com.seedling.seedling.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private String id;
    private String title;
    private String description;
    private String repositoryUrl;
    private String imageUrl;
    private UserDto author;
    private String createdAt;
    private String updatedAt;
}

