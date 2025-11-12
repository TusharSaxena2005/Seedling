package com.seedling.seedling.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection="Comment")
public class CommentEntity {
    @Id
    private String id;

    @DBRef
    private UserEntity author;

    @DBRef
    private PostEntity post;

    private String comment;

    @CreatedDate
    private LocalDateTime createdAt;
}
