package com.otavioyukio.school_manager_api.auth;

public record LoginRequestDTO (
        String email,
        String password
){
}
