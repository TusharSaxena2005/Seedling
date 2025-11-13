package com.seedling.seedling.dto;

import com.seedling.seedling.entity.ConnectionEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConnectionDto {
    private String id;
    private UserDto user;
    private UserDto connectedUser;
    private String createdAt;
    
    public static ConnectionDto fromEntity(ConnectionEntity e) {
        if (e == null) return null;
        return ConnectionDto.builder()
                .id(e.getId())
                .user(UserDto.fromEntity(e.getUserId()))
                .connectedUser(UserDto.fromEntity(e.getConnectedUserId()))
                .createdAt(e.getCreatedAt() != null ? e.getCreatedAt().toString() : null)
                .build();
    }
    
    public ConnectionEntity toEntity() {
        ConnectionEntity e = new ConnectionEntity();
        e.setId(this.id);
        e.setUserId(this.user != null ? this.user.toEntity() : null);
        e.setConnectedUserId(this.connectedUser != null ? this.connectedUser.toEntity() : null);
        return e;
    }
}
