package com.otavioyukio.school_manager_api.auth;

import java.time.LocalDateTime;

public record LoginResponseDTO (
        String token,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
