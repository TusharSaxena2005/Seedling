package com.seedling.seedling.dto;

import com.seedling.seedling.entity.ConnectionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionDto {
    private String id;
    private UserDto user;
    private UserDto connectedUser;
    private String createdAt;
}
