package com.otavioyukio.school_manager_api.auth;

import com.otavioyukio.school_manager_api.user.Role;

import java.time.LocalDateTime;

public record RegisterResponseDTO(
        String token,
        String email,
        String name,
        Role role,
        LocalDateTime createdAt
) {
}
