package com.otavioyukio.school_manager_api.auth;

public record RegisterRequestDTO(
        String name,
        String email,
        String password
) {
}
