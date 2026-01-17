package com.otavioyukio.school_manager_api.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO, Role role) {
        User newUser = UserMapper.toEntity(userRequestDTO, role);
        repository.save(newUser);
        return UserMapper.toResponse(newUser);
    }
}
