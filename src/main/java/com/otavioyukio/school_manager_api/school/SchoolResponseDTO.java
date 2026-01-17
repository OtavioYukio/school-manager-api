package com.otavioyukio.school_manager_api.school;

import java.time.LocalDateTime;

public record SchoolResponseDTO(
    Long id,
    String name,
    LocalDateTime createdAt
) {
    
}
