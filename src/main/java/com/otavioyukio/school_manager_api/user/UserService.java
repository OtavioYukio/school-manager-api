package com.otavioyukio.school_manager_api.user;

import com.otavioyukio.school_manager_api.commons.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new ObjectNotFoundException("User"));
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO, Role role) {
        if (repository.existsByEmail(userRequestDTO.email())) {
            throw new ObjectNotFoundException("User");
        }
        User newUser = UserMapper.toEntity(userRequestDTO, role);
        repository.save(newUser);
        return UserMapper.toResponse(newUser);
    }

    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User"));

        user.setEmail(userRequestDTO.email());
        user.setPassword(userRequestDTO.password());
        user.setSchool(userRequestDTO.school());

        User updatedUser = repository.save(user);

        return UserMapper.toResponse(updatedUser);
    }

    public void deleteUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User"));

        repository.delete(user);
    }

}
