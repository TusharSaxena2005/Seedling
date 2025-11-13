package com.seedling.seedling.dto;

import com.seedling.seedling.entity.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private LocalDate dob;
    private String state;
    private String district;
    private String miniBio;
    private String bio;
    private String category;
    private String profession;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static UserDto fromEntity(UserEntity e) {
        if (e == null) return null;
        return UserDto.builder()
                .id(e.getId())
                .firstName(e.getFirstName())
                .lastName(e.getLastName())
                .email(e.getEmail())
                .mobileNumber(e.getMobileNumber())
                .dob(e.getDob())
                .state(e.getState())
                .district(e.getDistrict())
                .miniBio(e.getMiniBio())
                .bio(e.getBio())
                .category(e.getCategory())
                .profession(e.getProfession())
                .profileImageUrl(e.getProfileImageUrl())
                .createdAt(e.getCreatedAt())
                .updatedAt(e.getUpdatedAt())
                .build();
    }

    public UserEntity toEntity() {
        UserEntity e = new UserEntity();
        e.setId(this.id);
        e.setFirstName(this.firstName);
        e.setLastName(this.lastName);
        e.setEmail(this.email);
        e.setMobileNumber(this.mobileNumber);
        e.setDob(this.dob);
        e.setState(this.state);
        e.setDistrict(this.district);
        e.setMiniBio(this.miniBio);
        e.setBio(this.bio);
        e.setCategory(this.category);
        e.setProfession(this.profession);
        e.setProfileImageUrl(this.profileImageUrl);
        // createdAt/updatedAt are typically managed by persistence layer
        // password intentionally not set here
        return e;
    }
}
