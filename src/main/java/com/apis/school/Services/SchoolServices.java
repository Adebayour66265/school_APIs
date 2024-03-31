package com.apis.school.Services;

import com.apis.school.dto.SchoolDto;
import com.apis.school.entity.School;
import com.apis.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServices {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;
    public SchoolServices(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDto create(SchoolDto dto){
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return  dto;
    }

    public List<SchoolDto> findAll(){
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }

    public List<School> findAllStudentInEachSchool(){
        return schoolRepository.findAll();
    }

    public void deleteSchoolById(Integer id){
        schoolRepository.deleteById(id);
    }
}