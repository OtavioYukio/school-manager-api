package com.otavioyukio.school_manager_api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
}
