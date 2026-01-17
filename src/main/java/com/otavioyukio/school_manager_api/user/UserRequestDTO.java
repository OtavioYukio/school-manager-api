package com.otavioyukio.school_manager_api.user;

import com.otavioyukio.school_manager_api.school.School;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @Email
        @Size(max = 255)
        String email,
        @NotBlank
        @Size(min = 8, max = 255)
        String password,
        @NotBlank
        School school
) {
}
