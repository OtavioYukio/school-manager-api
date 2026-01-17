package com.otavioyukio.school_manager_api.school;

import org.springframework.stereotype.Component;

@Component
public class SchoolMapper {
    public static School toEntity(SchoolRequestDTO schoolRequestDTO) {
        return new School(schoolRequestDTO.name());
    }

    public static SchoolResponseDTO toResponse(School school) {
        return new SchoolResponseDTO(
            school.getId(),
            school.getName(),
            school.getCreatedAt()
        );
    }
}
