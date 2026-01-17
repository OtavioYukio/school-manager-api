package com.otavioyukio.school_manager_api.school;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SchoolRequestDTO(
    @NotBlank
    @Size(max = 150)
    String name
) {
    
}
