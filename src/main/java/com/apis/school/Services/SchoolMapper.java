package com.apis.school.Services;

import com.apis.school.dto.SchoolDto;
import com.apis.school.entity.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto dto){
        return new School(dto.name());
    }

    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }
}
