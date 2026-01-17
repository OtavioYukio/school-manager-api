package com.otavioyukio.school_manager_api.user;

public class UserMapper {
    public static User toEntity(UserRequestDTO dto, Role role) {
        return new User(
                dto.email(),
                dto.password(),
                dto.school(),
                role
        );
    }

    public static UserResponseDTO toResponse(User entity) {
        return new UserResponseDTO(
                entity.getId(),
                entity.getEmail(),
                entity.getSchool(),
                entity.getRole(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
