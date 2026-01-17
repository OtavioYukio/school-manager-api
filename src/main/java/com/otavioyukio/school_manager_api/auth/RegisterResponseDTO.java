package com.otavioyukio.school_manager_api.auth;

import java.time.LocalDateTime;

public record RegisterResponseDTO(
        String token,
        String email,
        String name,
        LocalDateTime createdAt
) {
}
