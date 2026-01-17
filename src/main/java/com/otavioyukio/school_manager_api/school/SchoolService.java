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

}   
