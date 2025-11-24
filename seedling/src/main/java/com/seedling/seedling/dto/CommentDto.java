package com.seedling.seedling.dto;

import com.seedling.seedling.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String id;
    private UserDto authorId;
    private String postId;
    private String comment;
    private String createdAt;
}
