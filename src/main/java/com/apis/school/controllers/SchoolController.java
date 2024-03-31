package com.apis.school.controllers;

import com.apis.school.Services.SchoolServices;
import com.apis.school.dto.SchoolDto;
import com.apis.school.entity.School;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolServices schoolServices;

    public SchoolController(SchoolServices schoolServices) {
        this.schoolServices = schoolServices;
    }


    @PostMapping("/schools")
    public SchoolDto create(@RequestBody SchoolDto dto){
        return  schoolServices.create(dto);
    }


    @GetMapping("/schools")
    public List<SchoolDto> findAll(){
        return schoolServices.findAll();
    }

    @GetMapping("/getAllStudentInEachSchool")
    public List<School> findAllStudentInEachSchool(){
        return schoolServices.findAllStudentInEachSchool();
    }


    @DeleteMapping("/school/{school_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchoolById(@PathVariable("school_id") Integer id){
        schoolServices.deleteSchoolById(id);
    }
}

