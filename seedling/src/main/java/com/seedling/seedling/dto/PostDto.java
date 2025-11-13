package com.seedling.seedling.dto;


import com.seedling.seedling.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private UserDto author;
    private String createdAt;
    private String updatedAt;
    
    public static PostDto fromEntity(PostEntity e) {
        if (e == null) return null;
        return PostDto.builder()
                .id(e.getId())
                .title(e.getTitle())
                .description(e.getDescription())
                .imageUrl(e.getImageUrl())
                .author(UserDto.fromEntity(e.getAuthor()))
                .createdAt(e.getCreatedAt() != null ? e.getCreatedAt().toString() : null)
                .updatedAt(e.getUpdatedAt() != null ? e.getUpdatedAt().toString() : null)
                .build();
    }
    
    public PostEntity toEntity() {
        PostEntity e = new PostEntity();
        e.setId(this.id);
        e.setTitle(this.title);
        e.setDescription(this.description);
        e.setImageUrl(this.imageUrl);
        e.setAuthor(this.author.toEntity());
        return e;
    }
}
