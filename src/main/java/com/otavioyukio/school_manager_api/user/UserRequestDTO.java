package com.otavioyukio.school_manager_api.user;

import com.otavioyukio.school_manager_api.school.School;

public record UserRequestDTO(
        String email,
        String password,
        School school
) {
}
