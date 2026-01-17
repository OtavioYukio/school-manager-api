package com.otavioyukio.school_manager_api.user;

import com.otavioyukio.school_manager_api.school.School;

import java.time.LocalDateTime;

public record UserResponseDTO(
        Long id,
        String email,
        School school,
        Role role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
