package com.otavioyukio.school_manager_api.auth;

import com.otavioyukio.school_manager_api.user.Role;

import java.time.LocalDateTime;

public record LoginResponseDTO (
        String token,
        String name,
        String email,
        Role role,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
