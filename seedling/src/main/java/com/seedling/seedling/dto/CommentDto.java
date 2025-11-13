package com.seedling.seedling.dto;

import com.seedling.seedling.entity.CommentEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private String id;
    private UserDto authorId;
    private String postId;
    private String comment;
    private String createdAt;
    
    public static CommentDto fromEntity(CommentEntity commentEntity) {
        return CommentDto.builder()
                .id(commentEntity.getId())
                .authorId(UserDto.fromEntity(commentEntity.getAuthor()))
                .postId(commentEntity.getPost().getId())
                .comment(commentEntity.getComment())
                .createdAt(commentEntity.getCreatedAt().toString())
                .build();
    }
    
    public CommentEntity toEntity() {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(this.id);
        commentEntity.setAuthor(this.authorId.toEntity());
        commentEntity.setComment(this.comment);
        return commentEntity;
    }
}
