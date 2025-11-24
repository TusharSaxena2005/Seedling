package com.seedling.seedling.dto;


import com.seedling.seedling.entity.LikeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeDto {
    private String id;
    private UserDto user;
    private PostDto post;
    private String createdAt;
}
