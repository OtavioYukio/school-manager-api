package com.otavioyukio.school_manager_api.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterTeacherRequestDTO(
        @Email
        @Size(max = 255)
        String email,
        @NotBlank
        @Size(min = 8, max = 255)
        String password
) {
}
