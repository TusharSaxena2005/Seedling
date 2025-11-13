package com.seedling.seedling.dto;


import com.seedling.seedling.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {
    private String id;
    private String title;
    private String description;
    private String repositoryUrl;
    private String imageUrl;
    private UserDto author;
    private String createdAt;
    private String updatedAt;

    public static ProjectDto fromEntity(ProjectEntity e) {
        if (e == null) return null;
        return ProjectDto.builder()
                .id(e.getId())
                .title(e.getTitle())
                .description(e.getDescription())
                .repositoryUrl(e.getRepositoryUrl())
                .imageUrl(e.getImageUrl())
                .author(UserDto.fromEntity(e.getAuthor()))
                .createdAt(e.getCreatedAt() != null ? e.getCreatedAt().toString() : null)
                .updatedAt(e.getUpdatedAt() != null ? e.getUpdatedAt().toString() : null)
                .build();
    }
    public ProjectEntity toEntity() {
        ProjectEntity e = new ProjectEntity();
        e.setId(this.id);
        e.setTitle(this.title);
        e.setDescription(this.description);
        e.setRepositoryUrl(this.repositoryUrl);
        e.setImageUrl(this.imageUrl);
        e.setAuthor(this.author != null ? this.author.toEntity() : null);
        return e;
    }
}

