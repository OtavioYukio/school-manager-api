package com.otavioyukio.school_manager_api.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Value("${spring.jwt.secret}")
    private String secret;
}
