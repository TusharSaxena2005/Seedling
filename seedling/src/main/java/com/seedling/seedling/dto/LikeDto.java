package com.seedling.seedling.dto;


import com.seedling.seedling.entity.LikeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeDto {
    private String id;
    private UserDto user;
    private PostDto post;
    private String createdAt;
    
    public static LikeDto fromEntity(LikeEntity e) {
        if (e == null) return null;
        return LikeDto.builder()
                .id(e.getId())
                .user(UserDto.fromEntity(e.getUserId()))
                .post(PostDto.fromEntity(e.getPostId()))
                .createdAt(e.getCreatedAt() != null ? e.getCreatedAt().toString() : null)
                .build();
    }
    
    public LikeEntity toEntity() {
        LikeEntity e = new LikeEntity();
        e.setId(this.id);
        e.setUserId(this.user.toEntity());
        e.setPostId(this.post != null ? this.post.toEntity() : null);
        return e;
    }
}
