package com.otavioyukio.school_manager_api.school;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
    
    private final SchoolRepository repository;

    public SchoolResponseDTO createSchool(SchoolRequestDTO dto) {
        School newSchool = SchoolMapper.toEntity(dto);
        repository.save(newSchool);
        return SchoolMapper.toResponse(newSchool);
    }

    public SchoolResponseDTO updateSchoolById(Long id, SchoolRequestDTO schoolRequestDTO) {
        School school = repository.findById(id)
                        .orElseThrow(() -> new RuntimeException(
                            "School with id " + id + " not found.")
                        );
        school.setName(schoolRequestDTO.name());
        repository.save(school);
        return SchoolMapper.toResponse(school);
    }
    
}   
