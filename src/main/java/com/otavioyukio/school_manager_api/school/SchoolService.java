package com.otavioyukio.school_manager_api.school;

import java.util.Optional;

import com.otavioyukio.school_manager_api.commons.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {
    
    private final SchoolRepository repository;

    public School getSchoolById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("School"));
    }

    public SchoolResponseDTO createSchool(School newSchool) {
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

    public void deleteSchoolById(Long id) {
        Optional<School> school = repository.findById(id);
        if (school == null) {
            throw new RuntimeException("School with id " + id + " not found.");
        }
        repository.deleteById(id);
    }
    
}   
